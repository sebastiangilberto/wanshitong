package ar.com.sgilberto.validator;

/*

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.com.conexia.art.model.external.TransaccionExternal;
import ar.com.conexia.art.server.exception.TransactionValidationException;
import ar.com.conexia.art.validation.error.MessageError;

public class ValidationProvider {

	
	
	public static void validateTransaction(TransaccionExternal transaccionExterna) throws Exception{
		
		String tipo = transaccionExterna.getTipoTransaccion().toLowerCase();
		List<MessageError> messageList = new ArrayList<MessageError>();
		
		try {
			switch(tipo){
			case "regini":
				messageList = loadValidationsREGINI(transaccionExterna);
				break;
			case "ramctl":
				messageList = loadValidationsRAMCTL(transaccionExterna);
				break;
			case "ramalt":
				messageList = loadValidationsRAMALT(transaccionExterna);
				break;
			case "ramatr":
				messageList = loadValidationsRAMATR(transaccionExterna);
				break;
			case "ramdef":
				messageList = loadValidationsRAMDEF(transaccionExterna);
				break;
			case "ramder":
				messageList = loadValidationsRAMDER(transaccionExterna);
				break;
			case "inting":
				messageList = loadValidationsINTING(transaccionExterna);
				break;
			case "intevo":
				messageList = loadValidationsINTEVO(transaccionExterna);
				break;
			case "integr":
				messageList = loadValidationsINTEGR(transaccionExterna);
				break;
			default:
				break;
			}
			
		} catch (Exception ex) {
			TransactionValidationException trxe = new TransactionValidationException();
			trxe.setTransaccion(transaccionExterna);
			throw trxe;
		}

		for(MessageError messageError : messageList){
			if(messageError != null)
				transaccionExterna.addMessageError(messageError);
		}
		
	}

	private static List<MessageError> loadValidationsREGINI(TransaccionExternal transaccionExterna) throws Exception{

		List<MessageError> messageList = new ArrayList<MessageError>();
		MessageError messageError = null;
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion(), 6);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);

		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 13);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("ApellidoNombre", transaccionExterna.getAccidentado().getApellidoNombre());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("ApellidoNombre", transaccionExterna.getAccidentado().getApellidoNombre(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaNacimiento", transaccionExterna.getAccidentado().getFechaNacimiento());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaNacimiento", transaccionExterna.getAccidentado().getFechaNacimiento(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Sexo", transaccionExterna.getAccidentado().getSexo());
		messageList.add(messageError);
		
		messageError = ValidationStore.PossibleValuesValidation("Sexo", transaccionExterna.getAccidentado().getSexo(), Arrays.asList("F", "M"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitEmpresa", transaccionExterna.getAccidentado().getCuitEmpresa());
		messageList.add(messageError);
		
		messageError = ValidationStore.LenghtValidation("CuitEmpresa", transaccionExterna.getAccidentado().getCuitEmpresa(), 11);
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("CuitEmpresa", transaccionExterna.getAccidentado().getCuitEmpresa());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("CuitEmpresa", transaccionExterna.getAccidentado().getCuitEmpresa());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("PuestoDeTrabajo", transaccionExterna.getAccidentado().getPuestoDeTrabajo(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Telefono", transaccionExterna.getAccidentado().getTelefono(), 20);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Calle", transaccionExterna.getAccidentado().getDireccion().getCalle(), 20);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentado().getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentado().getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentado().getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentado().getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentado().getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentado().getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroCalle", transaccionExterna.getAccidentado().getDireccion().getNumeroCalle(), 10);
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroCalle", transaccionExterna.getAccidentado().getDireccion().getNumeroCalle());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroCalle", transaccionExterna.getAccidentado().getDireccion().getNumeroCalle());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Piso", transaccionExterna.getAccidentado().getDireccion().getPiso(), 3);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Departamento", transaccionExterna.getAccidentado().getDireccion().getDepartamento(), 3);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Barrio", transaccionExterna.getAccidentado().getDireccion().getBarrio(), 25);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Provincia", transaccionExterna.getAccidentado().getDireccion().getProvincia());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Provincia", transaccionExterna.getAccidentado().getDireccion().getProvincia(), 25);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPostal", transaccionExterna.getAccidentado().getDireccion().getCodigoPostal());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPostal", transaccionExterna.getAccidentado().getDireccion().getCodigoPostal(), 10);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoLocalidad", transaccionExterna.getAccidentado().getDireccion().getCodigoLocalidad(), 10);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente(), 3);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DependentAttributeValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), transaccionExterna.getAccidente().getRecaida(), "SI");
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.FechaHoraAccidenteValidation("FechaHoraAccidente", transaccionExterna);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("DescripcionAccidente", transaccionExterna.getAccidente().getDescripcionAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("DescripcionAccidente", transaccionExterna.getAccidente().getDescripcionAccidente(), 100);
		messageList.add(messageError);
	
		return messageList;
		
	}
	
	private static List<MessageError> loadValidationsRAMCTL(TransaccionExternal transaccionExterna) throws Exception {
		
		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;

		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion(), 6);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);

		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 13);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SinBajaLaboral", transaccionExterna.getAtencionMedica().getSinBajaLaboral());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaProximoControl", transaccionExterna.getAtencionMedica().getFechaProximoControl());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaProximoControl", transaccionExterna.getAtencionMedica().getFechaProximoControl(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroSiniestro", transaccionExterna.getAccidente().getNumeroSiniestro(), 19);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente(), 3);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Forma", transaccionExterna.getAccidente().getForma(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NaturalezaLesion", transaccionExterna.getAccidente().getNaturalezaLesion(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("ZonaAfectada", transaccionExterna.getAccidente().getZonaAfectada(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Recaida", transaccionExterna.getAccidente().getRecaida(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DependentAttributeValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), transaccionExterna.getAccidente().getRecaida(), "SI");
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);

		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
	}
	
	private static List<MessageError> loadValidationsRAMALT(TransaccionExternal transaccionExterna) throws Exception{

		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;

		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;
		
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion(), 6);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 13);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		
		 //  RAMALT - ITEM DIAGNOSTICO
		 
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMALT - ATENCION MEDICA
		 
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SinBajaLaboral", transaccionExterna.getAtencionMedica().getSinBajaLaboral());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("ConFirmaEmpleado", transaccionExterna.getAtencionMedica().getConFirmaEmpleado());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("ConFirmaEmpleado", transaccionExterna.getAtencionMedica().getConFirmaEmpleado());
		messageList.add(messageError);
		
		messageError = ValidationStore.DependentAttributeValidation("Conformidad", transaccionExterna.getAtencionMedica().getConformidad(), transaccionExterna.getAtencionMedica().getConFirmaEmpleado(), "SI");
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Conformidad", transaccionExterna.getAtencionMedica().getConformidad());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("ConRecalificacion", transaccionExterna.getAtencionMedica().getConRecalificacion());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("ConRecalificacion", transaccionExterna.getAtencionMedica().getConRecalificacion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaAltaDefinitiva", transaccionExterna.getAtencionMedica().getFechaAltaDefinitiva());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaAltaDefinitiva", transaccionExterna.getAtencionMedica().getFechaAltaDefinitiva(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Incapacidad", transaccionExterna.getAtencionMedica().getIncapacidad());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Incapacidad", transaccionExterna.getAtencionMedica().getIncapacidad());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("ControlPostAlta", transaccionExterna.getAtencionMedica().getControlPostAlta());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("ControlPostAlta", transaccionExterna.getAtencionMedica().getControlPostAlta());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		
		 //  RAMALT - ACCIDENTE
		 
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroSiniestro", transaccionExterna.getAccidente().getNumeroSiniestro(), 19);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente(), 3);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Forma", transaccionExterna.getAccidente().getForma(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NaturalezaLesion", transaccionExterna.getAccidente().getNaturalezaLesion(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("ZonaAfectada", transaccionExterna.getAccidente().getZonaAfectada(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Recaida", transaccionExterna.getAccidente().getRecaida(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DependentAttributeValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), transaccionExterna.getAccidente().getRecaida(), "SI");
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		
		 //  RAMALT - ITEM PRACTICA REALIZADA
		 
		
		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMALT - ITEM PRACTICA PRESCRIPTA
		 
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
		
	}
	
	private static List<MessageError> loadValidationsRAMDEF(TransaccionExternal transaccionExterna) throws Exception {
	
		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;
		
		
		 //	RAMDEF - SINIESTRO 
		 
		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;
		
		
		 //  RAMDEF - TRANSACCION
		 

		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion(), 6);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		
		 //  RAMDEF - PRESTADOR
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 13);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMDEF - ACCIDENTADO IDENTIFICACION
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		 //  RAMDEF - DIAGNOSTICO
		 
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		
		 //  RAMDEF - ITEM DIAGNOSTICO
		 
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMDEF - ATENCION MEDICA
		 
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SinBajaLaboral", transaccionExterna.getAtencionMedica().getSinBajaLaboral());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		
		 //  RAMDEF - ACCIDENTE
		 
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroSiniestro", transaccionExterna.getAccidente().getNumeroSiniestro(), 19);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Forma", transaccionExterna.getAccidente().getForma(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NaturalezaLesion", transaccionExterna.getAccidente().getNaturalezaLesion(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("ZonaAfectada", transaccionExterna.getAccidente().getZonaAfectada(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Recaida", transaccionExterna.getAccidente().getRecaida(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		
		 //  RAMDEF - ITEM PRACTICA REALIZADA
		 
		
		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMDEF - ITEM PRACTICA PRESCRIPTA
		 
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
	}

	private static List<MessageError> loadValidationsRAMATR(TransaccionExternal transaccionExterna) throws Exception {
	
		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;

		
		 //	RAMATR - SINIESTRO 
		 
		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;
		
		
		 //  RAMATR - TRANSACCION
		 
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion(), 6);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		
		 //  RAMATR - PRESTADOR
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 13);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMATR - ACCIDENTADO IDENTIFICACION
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		 //  RAMATR - DIAGNOSTICO
		 
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		
		 //  RAMATR - ITEM DIAGNOSTICO
		 
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMATR - ATENCION MEDICA
		 
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SinBajaLaboral", transaccionExterna.getAtencionMedica().getSinBajaLaboral());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		
		 //  RAMATR - ACCIDENTE
		 
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroSiniestro", transaccionExterna.getAccidente().getNumeroSiniestro(), 19);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Forma", transaccionExterna.getAccidente().getForma(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NaturalezaLesion", transaccionExterna.getAccidente().getNaturalezaLesion(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("ZonaAfectada", transaccionExterna.getAccidente().getZonaAfectada(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Recaida", transaccionExterna.getAccidente().getRecaida(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		
		 //  RAMATR - ITEM PRACTICA REALIZADA
		 
		
		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMATR - ITEM PRACTICA PRESCRIPTA
		 
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
	}

	private static List<MessageError> loadValidationsRAMDER(TransaccionExternal transaccionExterna) throws Exception {
		
		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;

		
		 //	RAMDER - SINIESTRO 
		 
		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;
		
		
		 //  RAMDER - TRANSACCION
		 
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion(), 6);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		
		 //  RAMDER - PRESTADOR
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 13);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMDER - ACCIDENTADO IDENTIFICACION
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		 //  RAMDER - DIAGNOSTICO
		 
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		
		 //  RAMDER - ITEM DIAGNOSTICO
		 
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMDER - ATENCION MEDICA
		 
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SinBajaLaboral", transaccionExterna.getAtencionMedica().getSinBajaLaboral());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IDEspecialidadDerivada", transaccionExterna.getAtencionMedica().getIdEspecialidadDerivada());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IDEspecialidadDerivada", transaccionExterna.getAtencionMedica().getIdEspecialidadDerivada());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("IDEspecialidadDerivada", transaccionExterna.getAtencionMedica().getIdEspecialidadDerivada());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IDEspecialidadDerivada", transaccionExterna.getAtencionMedica().getIdEspecialidadDerivada(), 3);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IDMotivoDerivacion", transaccionExterna.getAtencionMedica().getIdMotivoDerivacion());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IDMotivoDerivacion", transaccionExterna.getAtencionMedica().getIdMotivoDerivacion());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("IDMotivoDerivacion", transaccionExterna.getAtencionMedica().getIdMotivoDerivacion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IDMotivoDerivacion", transaccionExterna.getAtencionMedica().getIdMotivoDerivacion(), 1);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		
		 //  RAMDER - ACCIDENTE
		 
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroSiniestro", transaccionExterna.getAccidente().getNumeroSiniestro(), 19);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Forma", transaccionExterna.getAccidente().getForma(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NaturalezaLesion", transaccionExterna.getAccidente().getNaturalezaLesion(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("ZonaAfectada", transaccionExterna.getAccidente().getZonaAfectada(), 4);
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Recaida", transaccionExterna.getAccidente().getRecaida(), 2);
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		
		 //  RAMDER - ITEM PRACTICA REALIZADA
		 
		
		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  RAMDER - ITEM PRACTICA PRESCRIPTA
		 
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
	}

	private static List<MessageError> loadValidationsINTING(TransaccionExternal transaccionExterna) throws Exception {
		
		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;

		
		 //	INTING - SINIESTRO 
		 
		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;
		
		
		 //  INTING - TRANSACCION
		 
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		
		 //  INTING - PRESTADOR
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 11);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTING - ACCIDENTADO IDENTIFICACION
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		 //  INTING - DIAGNOSTICO
		 
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		
		 //  INTING - ITEM DIAGNOSTICO
		 
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTING - ATENCION MEDICA
		 
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdTipoServicio", transaccionExterna.getAtencionMedica().getIdTipoServicio());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdTipoServicio", transaccionExterna.getAtencionMedica().getIdTipoServicio());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("IdTipoServicio", transaccionExterna.getAtencionMedica().getIdTipoServicio());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("HabitacionCama", transaccionExterna.getAtencionMedica().getHabitacionCama());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("HabitacionCama", transaccionExterna.getAtencionMedica().getHabitacionCama());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("HabitacionCama", transaccionExterna.getAtencionMedica().getHabitacionCama());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		
		 //  INTING - ACCIDENTE
		 
		
		messageError = ValidationStore.MandatoryValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DependentAttributeValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), transaccionExterna.getAccidente().getRecaida(), "SI");
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		
		 //  INTING - ITEM PRACTICA REALIZADA
		 
		
		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTING - PRACTICA PRESCRIPTA
		 
		
		messageError = ValidationStore.NotEmptyListValidation("PPMPrescripta", transaccionExterna.getPracticaPrescripta().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.PracticaEmptyValidation("PPMPrescripta", transaccionExterna);
		messageList.add(messageError);
		
		
		 //  INTING - ITEM PRACTICA PRESCRIPTA
		 
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
	}
	
	private static List<MessageError> loadValidationsINTEVO(TransaccionExternal transaccionExterna) throws Exception {
		
		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;

		
		 //	INTEVO - SINIESTRO 
		 
		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;
		
		
		 //  INTEVO - TRANSACCION
		 
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		
		 //  INTEVO - PRESTADOR
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 11);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTEVO - ACCIDENTADO IDENTIFICACION
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		 //  INTEVO - DIAGNOSTICO
		 
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		
		 //  INTEVO - ITEM DIAGNOSTICO
		 
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTEVO - ATENCION MEDICA
		 
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		
		 //  INTEVO - ACCIDENTE
		 
		
		messageError = ValidationStore.MandatoryValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DependentAttributeValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), transaccionExterna.getAccidente().getRecaida(), "SI");
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		
		 //  INTEVO - ITEM PRACTICA REALIZADA
		 
		
		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTEVO - ITEM PRACTICA PRESCRIPTA
		 
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
	}
	
	private static List<MessageError> loadValidationsINTEGR(TransaccionExternal transaccionExterna) throws Exception {
	
		List<MessageError> messageList = new ArrayList<MessageError>();
		List<MessageError> listAux = new ArrayList<MessageError>();
		MessageError messageError = null;
		
		
		 //	INTEGR - SINIESTRO 
		 
		
		messageError = ValidationStore.SiniestroValidation(transaccionExterna);
		messageList.add(messageError);
		
		if(messageError != null)
			return messageList;

		
		 //  INTEGR - TRANSACCION
		 
		
		messageError = ValidationStore.MandatoryValidation("TipoTransaccion", transaccionExterna.getTipoTransaccion());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMensaje", transaccionExterna.getIdMensaje());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdMensaje", transaccionExterna.getIdMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("IdTraceoMensaje", transaccionExterna.getIdTraceoMensaje(), 12);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaOrigen", transaccionExterna.getFechaOrigen());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaOrigen", transaccionExterna.getFechaOrigen(), Arrays.asList("dd/MM/yyyy HH:mm:ss"));
		messageList.add(messageError);
		
		
		 //  INTEGR - PRESTADOR
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoUsuario", transaccionExterna.getPrestador().getCodigoUsuario(), 100);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CuitPrestador", transaccionExterna.getPrestador().getCuitPrestador(), 11);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoPrestador", transaccionExterna.getPrestador().getCodigoPrestador(), 10);
		messageList.add(messageError);
		
		listAux = ValidationStore.DatosMedicoValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTEGR - ACCIDENTADO IDENTIFICACION
		 
		
		messageError = ValidationStore.MandatoryValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("CodigoTipoDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getCodigoTipoDocumentoTrabajador(), 5);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("NumeroDocumentoTrabajador", transaccionExterna.getAccidentadoIdentificacion().getNumeroDocumentoTrabajador(), 8);
		messageList.add(messageError);
		
		
		 //  INTEGR - DIAGNOSTICO
		 
		
		messageError = ValidationStore.NotEmptyListValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxSizeValidation("Diagnostico", transaccionExterna.getDiagnostico().getItems(), 3);
		messageList.add(messageError);
		
		
		 //  INTEGR - ITEM DIAGNOSTICO
		 
		
		listAux = ValidationStore.DiagnosticosValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTEGR - ATENCION MEDICA
		 
		
		messageError = ValidationStore.DateValidation("FechaEstimativaAlta", transaccionExterna.getAtencionMedica().getFechaEstimativaAlta(), Arrays.asList("dd/MM/yyyy"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaDiferida", transaccionExterna.getAtencionMedica().getFechaDiferida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("SugerenciaRechazo", transaccionExterna.getAtencionMedica().getSugerenciaRechazo());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("IdMotivoAlta", transaccionExterna.getAtencionMedica().getIdMotivoAlta());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("IdMotivoAlta", transaccionExterna.getAtencionMedica().getIdMotivoAlta());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("IdMotivoAlta", transaccionExterna.getAtencionMedica().getIdMotivoAlta());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Informe", transaccionExterna.getAtencionMedica().getInforme());
		messageList.add(messageError);
		
		messageError = ValidationStore.MaxLenghtValidation("Informe", transaccionExterna.getAtencionMedica().getInforme(), 2000);
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("Gravedad", transaccionExterna.getAtencionMedica().getGravedad());
		messageList.add(messageError);
		
		
		 //  INTEGR - ACCIDENTE
		 
		
		messageError = ValidationStore.MandatoryValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraAccidente", transaccionExterna.getAccidente().getFechaHoraAccidente(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.NumericValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.PositiveValidation("TipoAccidente", transaccionExterna.getAccidente().getTipoAccidente());
		messageList.add(messageError);
		
		messageError = ValidationStore.MandatoryValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.BooleanValidation("Recaida", transaccionExterna.getAccidente().getRecaida());
		messageList.add(messageError);
		
		messageError = ValidationStore.DependentAttributeValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), transaccionExterna.getAccidente().getRecaida(), "SI");
		messageList.add(messageError);
		
		messageError = ValidationStore.DateValidation("FechaHoraRecaida", transaccionExterna.getAccidente().getFechaHoraRecaida(), Arrays.asList("dd/MM/yyyy HH:mm"));
		messageList.add(messageError);
		
		
		 //  INTEGR - ITEM PRACTICA REALIZADA
		 
		
		listAux = ValidationStore.PracticasRealizadasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		
		 //  INTEGR - ITEM PRACTICA PRESCRIPTA
		 
		
		listAux = ValidationStore.PracticasPrescriptasValidation(transaccionExterna);
		for(MessageError msj : listAux){
			messageList.add(msj);
		}
		
		return messageList;
	}

}

*/
