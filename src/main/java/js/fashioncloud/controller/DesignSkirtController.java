package js.fashioncloud.controller;

import js.fashioncloud.model.Feature;
import js.fashioncloud.model.Skirt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import static js.fashioncloud.model.Feature.Type;
import static js.fashioncloud.model.Feature.Type.*;
import static js.fashioncloud.model.Feature.filterByType;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignSkirtController {

    @GetMapping
    public String showDesignForm(Model model){

        List<Feature> features = Arrays.asList(
                new Feature("SMA", "Small", SIZE),
                new Feature("MED", "Medium", SIZE),
                new Feature("LAR", "Large", SIZE),
                new Feature("SHO", "Short", LENGTH),
                new Feature("MID", "Middle-length", LENGTH),
                new Feature("LON", "Long", LENGTH),
                new Feature("BLA", "Black", COLOR),
                new Feature("RED", "Red", COLOR),
                new Feature("GRE", "Grey", COLOR),
                new Feature("NAV", "Navy", COLOR),
                new Feature("PLA", "Plain", PATTERN),
                new Feature("CHE", "Chequered", PATTERN),
                new Feature("SPO", "Spotted", PATTERN),
                new Feature("STR", "Striped", PATTERN)
        );

        Type[] types = Type.values();

        for(Type type : types){

            model.addAttribute(type.toString().toLowerCase(), filterByType(features, type));

        }

        model.addAttribute("design", new Skirt());

        return "design";
    }
}
