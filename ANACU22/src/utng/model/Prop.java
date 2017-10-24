package utng.model;

import java.io.Serializable;

public class Prop implements Serializable{
	private String id;
	private String pk;
	private String pv;
	private String desc;
	private int seq;
	
	public Prop() {
		this("","","","",0);
	}

	public Prop(String id, String pk, String pv, String desc, int seq) {
		super();
		this.id = id;
		this.pk = pk;
		this.pv = pv;
		this.desc = desc;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getPv() {
		return pv;
	}
	public void setPv(String pv) {
		this.pv = pv;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "Prop [id=" + id + ", pk=" + pk + ", pv=" + pv + ", desc=" + desc + ", seq=" + seq + "]";
	}
	
	
}
