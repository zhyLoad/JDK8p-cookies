/**
 * 
 */
package com.test.jndi;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;

import com.test.jndi.entity.InetOrgPerson;
import com.test.jndi.entity.LdapConnection;

/**
 * @author 10007610
 *
 */
public interface Ldap {
	public void connect(LdapConnection ldapConnection) throws NamingException;
	public void search(String searchFilter,String searchBase,String[] returnedAtts) throws NamingException;
	public void update(String dn,Attribute attr) throws NamingException;
	public void add(InetOrgPerson inetOrgPerson) throws NamingException;
	public void delete(String dn) throws NamingException;
	public void close() throws NamingException;
}
