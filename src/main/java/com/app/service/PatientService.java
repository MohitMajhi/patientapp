package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.app.exception.DataNotFoundException;
import com.app.exception.WrongDataException;
import com.app.model.Patient;
import com.app.model.Services;
import com.app.repository.PatientRepo;

@Service
public class PatientService {
	
	@Autowired
	PatientRepo pr;
	
	@Autowired
	RestTemplate restTemplate;

	public List<Patient> allPatients() throws DataNotFoundException
	{
		List<Patient> p=pr.findAll();
		if(p.size()!=0)
		{
			return p;
		}
		else
			throw new DataNotFoundException();
	}
	public ModelAndView patientCount()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("patientCount", pr.findAll().size());
		mv.setViewName("count");
		return mv;
	}
	public Patient addPatient(int id,String fname,String lname) throws WrongDataException, DataNotFoundException
	{
		try{
			Patient p=new Patient(id,fname,lname);
			if(fname.length()!=0)
			{
				pr.save(p);
				return p;
			}
			else
				throw new WrongDataException("Giving First name is COMPULSORY");
			}
		catch(Exception e)
		{
			throw new DataNotFoundException("Patient not Added");
		}
	}
	
	public Patient search(int sid) throws DataNotFoundException
	{
		try {
		return pr.findById(sid).get();
		}
		catch(Exception e)
		{
			throw new DataNotFoundException("Patient Not Found");
		}
	}
	
	public Patient updatePatient(int id,String fname,String lname) throws DataNotFoundException
	{
		try{
			Patient p=new Patient(id,fname,lname);
			if(fname.length()!=0)
			{
				pr.save(p);
				return p;
			}
			else
				throw new WrongDataException("Giving First name is COMPULSORY");
			}
		catch(Exception e)
		{
			throw new DataNotFoundException("Patient not Added");
		}
	}
	
	public ModelAndView deletePatient(int sid)
	{
		ModelAndView mv=new ModelAndView();
		Patient p=pr.findById(sid).get();
		if(p!=null)
		{
			pr.delete(p);
			mv.setViewName("success");
		}
		else
		{
			mv.setViewName("fail");
		}
		return mv;
	
	}
	
	public ModelAndView allPatientDetails(int pid) throws DataNotFoundException
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("patientdata",this.search(pid));
		final String uri="http://localhost:8082/searchservice/"+""+pid;
		@SuppressWarnings("unchecked")
		List<Services> slist=restTemplate.getForObject(uri, List.class);
		mv.addObject("serviceList",slist);
		return mv;
	}
}
