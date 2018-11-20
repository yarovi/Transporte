package com.controladores;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entiadad.EDispositivo;
import com.utilidades.PathView;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {

	private static final Log LOG = LogFactory.getLog(DispositivoController.class);
	
	@GetMapping("/todo")
	public ModelAndView todoDispositivo()
	{
		ModelAndView moc = new ModelAndView(PathView.vistaallDispositivo);
		
		LOG.info("lista Dispositivos :" );			
		return moc;
	}
	@GetMapping("/cancel")
	public String redirecCancelDispositivo() {
		return "redirect:dispositivo/todo";
	}
	@GetMapping("mostrarfrm")
	public String redireccionDispositivo(@RequestParam(name="id", required=false) int id,Model modelo) {
		EDispositivo d= new EDispositivo();
		if(id!=0) {
			
		}
		modelo.addAttribute("modelo",d);
		return PathView.vistafrmDispositivo;
	}
	@PostMapping("/agregar")
	public String AgregarDispositivo(@Valid @ModelAttribute(name="mdispositivo") EDispositivo dispo,
			BindingResult bindingresult,Model mdl) {
		
		String vistaRetorno="";
		if(bindingresult.hasErrors())
			vistaRetorno=PathView.vistafrmDispositivo;
		else {
			if(dispo!=null) {
				if(dispo.getId()==0) {
					
					
				}else {
					
				}
			}
		}
		
		return vistaRetorno;
	}
	
}
