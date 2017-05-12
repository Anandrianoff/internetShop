package controller;

import form.AddProductForm;
import form.AddWarehouseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ProductService;
import service.impl.WarehouseService;
import util.AddWarehouseFormToWarehouse;

import javax.validation.Valid;

/**
 * Created by Andrey on 27.04.2017.
 */
@Controller
public class AdminController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "admin/addProduct", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddProductPage(Model model){
        model.addAttribute("productform", new AddProductForm());
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        return "admin/addProduct";
    }

    @RequestMapping(value = "admin/addProduct", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addProduct(@ModelAttribute("productform") @Valid AddProductForm form, BindingResult res, Model model){
        AddProductForm apf = new AddProductForm();
        apf.setWarehouses(warehouseService.getAllWarehouses());
        model.addAttribute("productform", apf);
//        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        if(!res.hasErrors()){
            productService.saveNewProduct(form);
        }

        return "redirect:/admin/addProduct";
    }

    @RequestMapping(value = "admin/warehouses", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddWarehousePage(Model model){
        model.addAttribute("warehouseform", new AddWarehouseForm());
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        return "admin/warehouses";
    }

    @RequestMapping(value = "/admin/warehouses/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addWarehouse(@ModelAttribute("warehouseform") @Valid AddWarehouseForm form, BindingResult result){
        if(!result.hasErrors()){
            warehouseService.saveNewWarehouse(form);
            return "redirect:/admin/warehouses";
        }else {
            //TODO: Обработка неправильного ввода
            return "redirect:/admin/warehouses";
        }
    }
}
