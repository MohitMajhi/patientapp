package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exception.DataNotFoundException;
import com.app.exception.WrongDataException;
import com.app.model.Patient;
import com.app.service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	PatientService ps;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/allpatients")
	public ModelAndView allPatients() throws DataNotFoundException
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("patientList", ps.allPatients());
		mv.setViewName("allpatients");
		return mv;
	}
	@GetMapping("/patientcount")
	public ModelAndView patientCount()
	{
		return ps.patientCount();
	}
	
	@RequestMapping("/addpatient")
	public String addPatient()
	{
		return "patientform";
	}
	@PostMapping("/savepatient")
	public String savePatient(@ModelAttribute("id") int id,@ModelAttribute("fname") String fname,@ModelAttribute("lname") String lname) throws WrongDataException, DataNotFoundException
	{
		Patient p=ps.addPatient(id, fname, lname);
		if(p!=null)
		{
			return "success";
		}
		else
			throw new DataNotFoundException("Data Not saved");
	}
	@GetMapping("/findpatientpage")
	public String findPatient()
	{
		return "find";
	}
	
	@GetMapping("/search")
	public ModelAndView search(@ModelAttribute("sid") int sid) throws DataNotFoundException 
	{
		ModelAndView mv=new ModelAndView();
		Patient p=new Patient();
		try
		{
		p=ps.search(sid);
		mv.addObject("patient",p);
		mv.setViewName("patient");
		return mv;
		}
		catch(Exception e)
		{
			throw new DataNotFoundException("Patient Not Found");
		}
	}
	@RequestMapping("/updateform")
	public String updateForm()
	{
		return "updateform";
	}
	@PostMapping("/updatepatient")
	public String updatePatient(@ModelAttribute("id") int id,@ModelAttribute("fname") String fname,@ModelAttribute("lname") String lname) throws WrongDataException, DataNotFoundException
	{
		Patient p=ps.addPatient(id, fname, lname);
		if(p!=null)
		{
			return "success";
		}
		else
			throw new DataNotFoundException("Data Not saved");
	}
	
	@GetMapping("/deletepatientpage")
	public String deletePage()
	{
		return "delete";
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@ModelAttribute("did") int did)
	{
		return ps.deletePatient(did);
	}
	
	@GetMapping("/patientdetailsearch")
	public String patientDetailSearch()
	{
		return "patientdetailsearch";
	}
	@GetMapping("/patientdetails")
	public ModelAndView patientDetails(@ModelAttribute("pid") int pid) throws DataNotFoundException
	{
		return ps.allPatientDetails(pid);
	}
}
