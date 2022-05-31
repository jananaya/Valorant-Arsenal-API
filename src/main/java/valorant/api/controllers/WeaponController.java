package valorant.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import types.Yardstick;
import java.util.ArrayList;
import model.ModelWeapon;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import schema.repository.WeaponRepository;
import schema.WeaponDTO;
import schema.WeaponMapper;

@CrossOrigin
@RestController
public class WeaponController {

    private final ModelWeapon model;
    private final Map sortingYardstick;
    
    public WeaponController() {
        this.model = new ModelWeapon(new WeaponRepository());
        this.sortingYardstick = new HashMap();
        
        sortingYardstick.put("specs", Yardstick.NUMBER_OF_SPECS);
        sortingYardstick.put("category", Yardstick.CATEGORY);
        sortingYardstick.put("damage", Yardstick.DAMAGE);
        sortingYardstick.put("rateOfFire", Yardstick.RATE_OF_FIRE);
        sortingYardstick.put("rating", Yardstick.RATING);
    }
    
    @GetMapping("/arsenal/{name}")
    public WeaponDTO searchWeapon(@PathVariable("name") String name) {
        return WeaponMapper.toDto(
            this.model.searchByName(name)
        );
    }
    
    @GetMapping("/arsenal")
    public ArrayList<WeaponDTO> sendWeapons(@RequestParam(value="sort", defaultValue = "") String sort) {
        if (this.sortingYardstick.containsKey(sort)) {
            return WeaponMapper.toDto(
                    this.model.sort((Yardstick)this.sortingYardstick.get(sort))
            );
        }
        
        return WeaponMapper.toDto(
                this.model.getWeapons()
        );
    }

    @GetMapping("/arsenal/category")
    public ArrayList<String> sendCategories() {
        return this.model.getCategories();
    }
    
    @GetMapping("/arsenal/category/{category}")
    public ArrayList<WeaponDTO> sendWeaponsFromCategory(@PathVariable("category") String category) {
        return WeaponMapper.toDto(
            this.model.searchByCategory(category)
        );
    }
}
