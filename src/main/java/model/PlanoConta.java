package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "clientes")

public class PlanoConta {
	
	private int idPlanoConta;
	private String nmPlanoConta;
	private String tpPlanoConta;
	private String DescriçaoPlanoConta;
	private boolean isAtivoPlanoConta;
	private int idUsuarioCriador;
	
	public int getIdPlanoConta() {
		return idPlanoConta;
	}
	public void setIdPlanoConta(int idPlanoConta) {
		this.idPlanoConta = idPlanoConta;
	}
	public String getNmPlanoConta() {
		return nmPlanoConta;
	}
	public void setNmPlanoConta(String nmPlanoConta) {
		this.nmPlanoConta = nmPlanoConta;
	}
	public String getTpPlanoConta() {
		return tpPlanoConta;
	}
	public void setTpPlanoConta(String tpPlanoConta) {
		this.tpPlanoConta = tpPlanoConta;
	}
	public String getDescriçaoPlanoConta() {
		return DescriçaoPlanoConta;
	}
	public void setDescriçaoPlanoConta(String descriçaoPlanoConta) {
		DescriçaoPlanoConta = descriçaoPlanoConta;
	}
	public boolean isAtivoPlanoConta() {
		return isAtivoPlanoConta;
	}
	public void setAtivoPlanoConta(boolean isAtivoPlanoConta) {
		this.isAtivoPlanoConta = isAtivoPlanoConta;
	}
	public int getIdUsuarioCriador() {
		return idUsuarioCriador;
	}
	public void setIdUsuarioCriador(int idUsuarioCriador) {
		this.idUsuarioCriador = idUsuarioCriador;
	}

}
