/**
 * 
 */
package com.test.jndi.entity;

/**
 * @author 10007610
 *
 */
public class InetOrgPerson {
	
	private String uid;

	private String sn;
	
	private String cn;
	
	private String password;
	
	private String dn;
	
	

	public InetOrgPerson(String uid, String sn, String cn, String password,String dn) {
		super();
		this.uid = uid;
		this.sn = sn;
		this.cn = cn;
		this.password = password;
		this.dn = dn;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}
	

	
	
}
