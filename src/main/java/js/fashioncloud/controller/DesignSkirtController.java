package js.fashioncloud.controller;

import js.fashioncloud.model.Feature;
import js.fashioncloud.model.Order;
import js.fashioncloud.model.Skirt;
import js.fashioncloud.model.User;
import js.fashioncloud.repository.FeatureRepository;
import js.fashioncloud.repository.SkirtRepository;
import js.fashioncloud.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static js.fashioncloud.model.Feature.filterByType;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignSkirtController {

    private final FeatureRepository featureRepository;

    private final SkirtRepository skirtRepository;

    private final UserRepository userRepository;

    @Autowired
    public DesignSkirtController(FeatureRepository featureRepository, SkirtRepository skirtRepository,
                                 UserRepository userRepository) {

        this.featureRepository = featureRepository;

        this.skirtRepository = skirtRepository;

        this.userRepository = userRepository;
    }

    @ModelAttribute(name = "design")
    public Skirt skirt(){
        return new Skirt();
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal){

        this.provideFeaturesData(model);

        String username = principal.getName();

        User user = userRepository.findUserByUsername(username);

        model.addAttribute("user", user);

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Skirt design, BindingResult bindingResult, Model model,
                                @ModelAttribute Order order){

        if(bindingResult.hasErrors()){

            this.provideFeaturesData(model);

            return "design";
        }

        Skirt saved = skirtRepository.save(design);

        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private void provideFeaturesData(Model model){

        List<Feature> features = new ArrayList<>();

        featureRepository.findAll().forEach(e -> features.add(e));

        Feature.Type[] types = Feature.Type.values();

        for(Feature.Type type : types){

            model.addAttribute(type.toString().toLowerCase(), filterByType(features, type));
        }

    }

}
