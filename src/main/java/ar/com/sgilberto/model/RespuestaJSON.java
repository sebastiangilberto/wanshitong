package ar.com.sgilberto.model;

import ar.com.sgilberto.enumerator.TrxStatus;

public class RespuestaJSON {

	public Object response;
	public TrxStatus status;

	public RespuestaJSON(Object response, TrxStatus status) {
		this.response = response;
		this.status = status;
	}

	public RespuestaJSON(String response, TrxStatus status) {
		this.response = response;
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public TrxStatus getStatus() {
		return status;
	}

	public void setStatus(TrxStatus status) {
		this.status = status;
	}

}
