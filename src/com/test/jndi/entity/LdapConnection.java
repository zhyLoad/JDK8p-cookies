/**
 * 
 */
package com.test.jndi.entity;

/**
 * @author 10007610
 *
 */
public class LdapConnection {

	private String ldapServerUrl;
	
	private String ldapServerAccount;
	
	private String ldapServerPassword;
	
	private String ldapServerAuthenticationType;
	
	

	public LdapConnection(String ldapServerUrl, String ldapServerAccount,
			String ldapServerPassword, String ldapServerAuthenticationType) {
		super();
		this.ldapServerUrl = ldapServerUrl;
		this.ldapServerAccount = ldapServerAccount;
		this.ldapServerPassword = ldapServerPassword;
		this.ldapServerAuthenticationType = ldapServerAuthenticationType;
	}

	public String getLdapServerUrl() {
		return ldapServerUrl;
	}

	public void setLdapServerUrl(String ldapServerUrl) {
		this.ldapServerUrl = ldapServerUrl;
	}

	public String getLdapServerAccount() {
		return ldapServerAccount;
	}

	public void setLdapServerAccount(String ldapServerAccount) {
		this.ldapServerAccount = ldapServerAccount;
	}

	public String getLdapServerPassword() {
		return ldapServerPassword;
	}

	public void setLdapServerPassword(String ldapServerPassword) {
		this.ldapServerPassword = ldapServerPassword;
	}

	public String getLdapServerAuthenticationType() {
		return ldapServerAuthenticationType;
	}

	public void setLdapServerAuthenticationType(String ldapServerAuthenticationType) {
		this.ldapServerAuthenticationType = ldapServerAuthenticationType;
	}
	
	
}
