package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Grade;
import lv.venta.service.IFilteringService;

@Controller
@RequestMapping("/filter")
public class FilteringController {
	
	@Autowired
	private IFilteringService filterService;
	
	
	@GetMapping("/grade/failed")//localhost:8080/filter/grade/failed
	public String getFilterGradeFailed(Model model) {
		
		try
		{
			ArrayList<Grade> dataFromService = filterService.selectFailedGradesInSystem();
			model.addAttribute("mypackage", dataFromService);
			return "show-all-grades-page";//will show show-all-grades-page.html file with failed grades
		}
		catch (Exception e) {
			model.addAttribute("mypackage", e.getMessage());
			return "error-page";// will show error-page.html page with exception message
		}
		
	}

}