/**
 * 
 */
package com.test.jndi;

/**
 * @author 10007610
 *
 */
public class Factory {
	private static Ldap instance;
	public synchronized static Ldap createInstance() {
		if (instance == null) {
			try {
				instance = (Ldap) Class.forName("com.test.jndi.LdapImpl").newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
		}
		return instance;
	}
}
