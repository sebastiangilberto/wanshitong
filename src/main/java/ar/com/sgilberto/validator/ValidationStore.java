package ar.com.sgilberto.validator;

/*

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ar.com.conexia.art.helpers.ValidationHelper;
import ar.com.conexia.art.model.external.AccidentadoIdentificacion;
import ar.com.conexia.art.model.external.Accidente;
import ar.com.conexia.art.model.external.Diagnostico;
import ar.com.conexia.art.model.external.ItemDiagnostico;
import ar.com.conexia.art.model.external.ItemPracticaPrescripta;
import ar.com.conexia.art.model.external.ItemPracticaRealizada;
import ar.com.conexia.art.model.external.PracticaPrescripta;
import ar.com.conexia.art.model.external.PracticaRealizada;
import ar.com.conexia.art.model.external.Prestador;
import ar.com.conexia.art.model.external.TransaccionExternal;
import ar.com.conexia.art.persistence.DataService;
import ar.com.conexia.art.utils.Constants;
import ar.com.conexia.art.utils.DateUtil;
import ar.com.conexia.art.utils.NumberUtils;
import ar.com.conexia.art.validation.error.MessageError;

public class ValidationStore {
	
	public static MessageError BooleanValidation(String campo, String value){
		MessageError msj = null;
		if(!value.isEmpty()){
			if( !"SI".equals(value.toUpperCase()) && !"NO".equals(value.toUpperCase()))
				msj = new MessageError("El campo "+ campo +" debe ser booleano [Si|No]");
		}
		return msj;
	}
	
	public static MessageError DateValidation(String campo, String value, List<String>formatInputList){
		MessageError msj = null;
		if(!value.isEmpty()){
			for(String formatInput : formatInputList){
				try{
					DateUtil.parseStringToDateFormatted(value, formatInput);
					msj = null;
				} 
				catch(Exception e){ 
					msj = new MessageError("El campo "+ campo +" no tiene formato correcto");
				}
			}
		}
		return msj;
	}
	
	public static MessageError DependentAttributeValidation(String campo, String value, String valueDependent, String expectedValue){
		MessageError msj = null;
		if(valueDependent.equalsIgnoreCase(expectedValue)){
			if(value.isEmpty() || value == null)
				msj = new MessageError("El campo "+ campo +" es obligatorio");
		}
		return msj;
	}
	
	public static MessageError EmptyListValidation(String campo, List<?> list){
		MessageError msj = null;
		if(!list.isEmpty())
			msj = new MessageError("La lista "+ campo +" debe ser vacía");
		return msj;
	}
	
	public static MessageError EmptyValidation(String campo, String value){
		MessageError msj = null;
		if(!value.isEmpty())
			msj = new MessageError("El campo "+ campo +" debe ser vacío");
		return msj;
	}
	
	public static MessageError LenghtValidation(String campo, String value, int lenght){
		MessageError msj = null;
		if(value.length() != lenght)
			msj = new MessageError("El campo "+ campo +" debe tener "+ lenght + " caracteres");
		return msj;
	}
	
	public static MessageError MandatoryValidation(String campo, String value){
		MessageError msj = null;
		if( value == null || "".equals(value) )
			msj = new MessageError("El campo "+ campo +" es obligatorio");
		return msj;
	}
	
	public static MessageError MaxLenghtValidation(String campo, String value, int maxLenght){
		MessageError msj = null;
		if(!value.isEmpty()){
			if(value.length() > maxLenght)
				msj = new MessageError("El campo "+ campo +" no debe superar más de "+ maxLenght +" caracteres");
		}
		return msj;
	}
	
	public static MessageError MaxSizeValidation(String campo, List<?> list, int maxSize){
		MessageError msj = null;
		if(list.size() > maxSize)
			msj = new MessageError("La lista "+ campo +" no debe superar más de "+ maxSize +" items");
		return msj;
	}
	
	public static MessageError MinLenghtValidation(String campo, String value, int minLenght){
		MessageError msj = null;
		if(!value.isEmpty()){
			if(value.length() < minLenght)
				msj = new MessageError("El campo "+ campo +" debe superar más de "+ minLenght +" caracteres");
		}
		return msj;
	}
	
	public static MessageError MinSizeValidation(String campo, List<?> list, int minSize){
		MessageError msj = null;
		if(list.size() < minSize)
			msj = new MessageError("La lista "+ campo +" debe superar más de "+ minSize +" items");
		return msj;
	}
	
	public static MessageError NotEmptyListValidation(String campo, List<?> list){
		MessageError msj = null;
		if(list.isEmpty())
			msj = new MessageError("La lista "+ campo +" debe tener al menos 1 item");
		return msj;
	}
	
	public static MessageError NotEmptyValidation(String campo, String value){
		MessageError msj = null;
		if(value.isEmpty())
			msj = new MessageError("El campo "+ campo +" no debe estar vacío");
		return msj;
	}
	
	public static MessageError NumericValidation(String campo, String value){
		MessageError msj = null;
		if(!value.isEmpty()){
			if(!StringUtils.isNumeric(value))
				msj = new MessageError("El campo "+ campo +" debe ser numérico");
		}
		return msj;
	}
	
	public static MessageError PositiveValidation(String campo, String value){
		MessageError msj = null;
		if(!value.isEmpty()){
			if(NumberUtils.isNumber(value)){
				if(Math.signum(Double.parseDouble(value)) < 0){
					msj = new MessageError("El campo "+ campo +" debe ser positivo");
				}
			}
		}
		return msj;
	}
	
	public static MessageError PossibleValuesValidation(String campo, String value, List<String> possibleValues){
		MessageError msj = null;
		Boolean valido = false;
		for(String possibleValue : possibleValues){
			if(possibleValue.toUpperCase().equals(value.toUpperCase()))
				valido = true;
		}
		if(!valido){
			msj = new MessageError("El campo "+ campo +" debe ser "+ possibleValues.toString());
		}
		
		return msj;
	}
	
	public static MessageError SizeValidation(String campo, List<?>list, int size){
		MessageError msj = null;
		if(list.size() != size)
			msj = new MessageError("La lista "+ campo +" debe tener "+ size + " items");
		return msj;
	}
	
	public static MessageError SiniestroValidation(TransaccionExternal transaccionExterna) throws Exception{
		
		MessageError msj = null;
		AccidentadoIdentificacion accidentado = transaccionExterna.getAccidentadoIdentificacion();
		Accidente accidente = transaccionExterna.getAccidente();
		String numeroDocumento = accidentado.getNumeroDocumentoTrabajador();
		String codigoDocumento = accidentado.getCodigoTipoDocumentoTrabajador();
		String numeroSiniestro = accidente.getNumeroSiniestro();
		String fechaHoraAccidente = accidente.getFechaHoraAccidente();
		String respuesta = "";
		
		if(StringUtils.isNumeric(codigoDocumento))
			codigoDocumento = (DataService.getInstance().getAccidentadoTipoDocumentoAbreviatura(codigoDocumento));
	
		if (!DataService.getInstance().getTieneAccidenteAbierto(codigoDocumento, numeroDocumento)){
			msj = new MessageError("No existe un siniestro abierto para el trabajador.");
			return msj;
		}
		
		respuesta = DataService.getInstance().getAtencionMedicaAccidenteID(
				codigoDocumento, 
				numeroDocumento,
				numeroSiniestro, 
				fechaHoraAccidente);
				
		if(respuesta.equals("FaltanDatos"))			
			msj = new MessageError("Múltiples Siniestros Abiertos, por favor indique el número de siniestro o la fecha de accidente");
		if(respuesta.equals("NoHayCoincidencia"))
			msj = new MessageError("Múltiples Siniestros Abiertos, el NumeroSiniestro y la FechaHoraAccidente informada no coincide con un siniestro abierto");
		
		return msj;
	}	
	
	public static MessageError FechaHoraAccidenteValidation(String campo, TransaccionExternal transaccionExterna) throws Exception{
		
		Accidente accidente = transaccionExterna.getAccidente();
		MessageError msj = null;
		Boolean tieneRecaida = accidente.getRecaida().equalsIgnoreCase("SI");
		Boolean existeFechaDenuncia = false;
		
		if(tieneRecaida){
			existeFechaDenuncia = DataService.getInstance().getTieneFechaDenuncia(transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), transaccionExterna.getAccidente().getFechaHoraAccidente());
		
			if(!existeFechaDenuncia){
				msj = new MessageError("El campo "+ campo +" no coincide con un accidente anterior");
			}
		}
		
		return msj;
			
	}
	
	public static MessageError DatosPrestadorValidation(TransaccionExternal transaccionExterna) throws Exception{
		
		Prestador prestador = transaccionExterna.getPrestador();
		String idPrestador = "";
		String idUsuarioPrestador;
		String idMedicoPrestador;
		MessageError msj = null;
		
		idPrestador = DataService.getInstance().getPrestadorIDFromCod(prestador.getCodigoPrestador());
		
		if(idPrestador.isEmpty()){
			msj = new MessageError("Prestador inexistente");
			return msj;
		}
		
		idUsuarioPrestador = DataService.getInstance().getPrestadorIDUsuarioPrestador(idPrestador, prestador.getCodigoUsuario());
		
		if(idUsuarioPrestador.isEmpty()){
			msj = new MessageError("Usuario inexistente");
			return msj;
		}
		
		idMedicoPrestador = DataService.getInstance().getPrestadorIDMedicoPrestador(idPrestador, prestador);
		
		if(idMedicoPrestador.isEmpty()){
			msj = new MessageError("Médico inexistente");
			return msj;
		}
		
		return msj;
	}
	
	public static List<MessageError> DatosMedicoValidation(TransaccionExternal transaccionExterna) throws Exception{
		
		Prestador prestador = transaccionExterna.getPrestador();
		Boolean tieneIdMedico = !prestador.getIdMedico().isEmpty();
		Boolean tieneDatosMed = !(prestador.getNumeroDocumentoMedico().isEmpty() && prestador.getTipoDocumentoMedico().isEmpty());
		Boolean tieneMatricula = !prestador.getMatriculaMedico().isEmpty();
		String idMedicoGenerico = "";
		List<MessageError> list = new ArrayList<MessageError>();
		MessageError msj = null;
		
		if(tieneIdMedico){
			msj = NumericValidation("IDMedico", prestador.getIdMedico());
			list.add(msj);
			msj = PositiveValidation("IDMedico", prestador.getIdMedico());
			list.add(msj);
			msj = MaxLenghtValidation("IDMedico", transaccionExterna.getPrestador().getIdMedico(), 10);
			list.add(msj);
			}
		if(tieneMatricula){
			msj = MaxLenghtValidation("MatriculaMedico", prestador.getMatriculaMedico(), 10);
			list.add(msj);
		}
		if(tieneDatosMed){
			msj = MaxLenghtValidation("TipoDocumentoMedico", prestador.getTipoDocumentoMedico(), 5);
			list.add(msj);
			msj = NumericValidation("NumeroDocumentoMedico", prestador.getNumeroDocumentoMedico());
			list.add(msj);
			msj = PositiveValidation("NumeroDocumentoMedico", prestador.getNumeroDocumentoMedico());
			list.add(msj);
			msj = MaxLenghtValidation("NumeroDocumentoMedico", prestador.getNumeroDocumentoMedico(), 8);
			list.add(msj);
		}
		if(!(tieneIdMedico || tieneDatosMed ||  tieneMatricula)){
			idMedicoGenerico = DataService.getInstance().getPrestadorIDMedicoGenerico(prestador.getCodigoPrestador());
			if(idMedicoGenerico.isEmpty()){
				msj = new MessageError("Debe indicar un Médico");
				list.add(msj);
			}
		}
		
		if(ValidationHelper.isListEmpty(list)){
			msj = DatosPrestadorValidation(transaccionExterna);
			list.add(msj);
		}
		
		return list;
	}
	
	public static List<MessageError> DiagnosticosValidation(TransaccionExternal transaccionExterna) throws Exception{
		
		Diagnostico diagnostico = transaccionExterna.getDiagnostico();
		List<MessageError> list = new ArrayList<MessageError>();
		MessageError msj = null;
		
		for(ItemDiagnostico itemDiagnostico : diagnostico.getItems()) {
		
			msj = MandatoryValidation("CodigoDiagnostico", itemDiagnostico.getCodigoDiagnostico());
			list.add(msj);
			
			msj = MaxLenghtValidation("CodigoDiagnostico", itemDiagnostico.getCodigoDiagnostico(), 10);
			list.add(msj);
			
			msj = MandatoryValidation("ParteCuerpo", itemDiagnostico.getParteCuerpo());
			list.add(msj);
			
			msj = MaxLenghtValidation("ParteCuerpo", itemDiagnostico.getParteCuerpo(), 30);
			list.add(msj);
			
			if(!transaccionExterna.getTipoTransaccion().equalsIgnoreCase("RAMCTL")){
				msj = MaxLenghtValidation("Movimiento", itemDiagnostico.getMovimiento(), 100);
				list.add(msj);
			}
		}
		
		return list;
	}
	
	public static MessageError PracticaEmptyValidation(String campo, TransaccionExternal transaccionExterna) throws Exception{
		MessageError msj = null;
		Boolean tieneItem = false;	
		
		if(campo.equalsIgnoreCase("PPMRealizada")){
			PracticaRealizada ppm = transaccionExterna.getPracticaRealizada();
			
			for(ItemPracticaRealizada item : ppm.getItems()){
				if(!ValidationHelper.isPracticaRealizadaEmpty(item))
					tieneItem = true;
			}
		}
		
		if(campo.equalsIgnoreCase("PPMPrescripta")){
			PracticaPrescripta ppm = transaccionExterna.getPracticaPrescripta();
			
			for(ItemPracticaPrescripta item : ppm.getItems()){
				if(!ValidationHelper.isPracticaPrescriptaEmpty(item))
					tieneItem = true;
			}
		
		}
	
		if(!tieneItem)
			msj = new MessageError("La practica "+ campo +" debe tener al menos 1 item");
			
		return msj;
	}
	
	public static List<MessageError> PracticasPrescriptasValidation(TransaccionExternal transaccionExterna) throws Exception{
		
		PracticaPrescripta ppm = transaccionExterna.getPracticaPrescripta();
		Prestador prestador = transaccionExterna.getPrestador();
		List<MessageError> list = new ArrayList<MessageError>();
		MessageError msj = null;
		String idPractica = "";
		
		for(ItemPracticaPrescripta itemPractica : ppm.getItems()) {
			
			if(!ValidationHelper.isPracticaPrescriptaEmpty(itemPractica)){
				
				msj = MandatoryValidation("Codigo", itemPractica.getCodigo());
				list.add(msj);
				
				msj = MaxLenghtValidation("Codigo", itemPractica.getCodigo(), 25);
				list.add(msj);
				
				msj = MandatoryValidation("Cantidad", itemPractica.getCantidad());
				list.add(msj);
				
				msj = NumericValidation("Cantidad", itemPractica.getCantidad());
				list.add(msj);
				
				msj = PositiveValidation("Cantidad", itemPractica.getCantidad());
				list.add(msj);
				
				msj = MaxLenghtValidation("Cantidad", itemPractica.getCantidad(), 2);
				list.add(msj);
				
				msj = MandatoryValidation("Observaciones", itemPractica.getObservaciones());
				list.add(msj);
				
				msj = MaxLenghtValidation("Observaciones", itemPractica.getObservaciones(), 250);
				list.add(msj);
				
				msj = MandatoryValidation("Efector", itemPractica.getEfector());
				list.add(msj);
				
				msj = MaxLenghtValidation("Efector", itemPractica.getEfector(), 25);
				list.add(msj);
				
				msj = MandatoryValidation("Turno", itemPractica.getTurno());
				list.add(msj);
				
				msj = DateValidation("Turno", itemPractica.getTurno(), Arrays.asList("dd/MM/yyyy HH:mm"));
				list.add(msj);
				
				msj = PossibleValuesValidation("Efector", itemPractica.getEfector(), Arrays.asList("Misma Institucion", "A coordinar por la A.R.T."));
				list.add(msj);
				
				if(ValidationHelper.isPracticaPrescriptaComplete(itemPractica) && msj == null){
					if(StringUtils.equals(Constants.MISMA_INSTITUCION.getValue(), itemPractica.getEfector())){
						idPractica = DataService.getInstance().getPracticaMedicaID(itemPractica.getCodigo(), prestador.getCodigoPrestador());
					} else if(StringUtils.equals(Constants.A_COORDINAR_POR_ART.getValue(), itemPractica.getEfector())){
						idPractica = DataService.getInstance().getPracticaACoordinarValida(itemPractica.getCodigo());
					}
				
					if(idPractica.isEmpty()) {
						msj = new MessageError("La practica prescripta "+ itemPractica.getCodigo() + " no se encuentra habilitada");
						list.add(msj);
					}
				}
			}
		}
		
		return list;
	}
	
	public static List<MessageError> PracticasRealizadasValidation(TransaccionExternal transaccionExterna) throws Exception{
		
		PracticaRealizada ppm = transaccionExterna.getPracticaRealizada();
		Prestador prestador = transaccionExterna.getPrestador();
		List<MessageError> list = new ArrayList<MessageError>();
		MessageError msj = null;
		
		for(ItemPracticaRealizada itemPractica : ppm.getItems()) {
			
			if(!ValidationHelper.isPracticaRealizadaEmpty(itemPractica)){
		
				msj = MandatoryValidation("Codigo", itemPractica.getCodigo());
				list.add(msj);
				
				msj = MaxLenghtValidation("Codigo", itemPractica.getCodigo(), 25);
				list.add(msj);
				
				msj = MandatoryValidation("Cantidad", itemPractica.getCantidad());
				list.add(msj);
				
				msj = NumericValidation("Cantidad", itemPractica.getCantidad());
				list.add(msj);
				
				msj = PositiveValidation("Cantidad", itemPractica.getCantidad());
				list.add(msj);
				
				msj = MaxLenghtValidation("Cantidad", itemPractica.getCantidad(), 2);
				list.add(msj);
				
				msj = MandatoryValidation("Observaciones", itemPractica.getObservaciones());
				list.add(msj);
				
				msj = MaxLenghtValidation("Observaciones", itemPractica.getObservaciones(), 250);
				list.add(msj);
				
				msj = MandatoryValidation("ViaFacturacion", itemPractica.getViaFacturacion());
				list.add(msj);
				
				msj = MaxLenghtValidation("ViaFacturacion", itemPractica.getViaFacturacion(), 20);
				list.add(msj);
				
				if(ValidationHelper.isPracticaRealizadaComplete(itemPractica)){
					if(DataService.getInstance().getPracticaMedicaID(itemPractica.getCodigo(), prestador.getCodigoPrestador()).isEmpty()) {
						msj = new MessageError("La practica realizada " + itemPractica.getCodigo() + " no se encuentra habilitada");
						list.add(msj);
					}
				}
			}
		}
			
		return list;
	}
	
}

*/