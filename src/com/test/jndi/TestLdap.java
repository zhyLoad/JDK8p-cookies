/**
 * 
 */
package com.test.jndi;

import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;

import com.test.jndi.entity.InetOrgPerson;
import com.test.jndi.entity.LdapConnection;

/**
 * @author 10007610
 *
 */
public class TestLdap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ldap ldap =  null;
		try {
			ldap = Factory.createInstance();
			
			LdapConnection ldapConnection = new LdapConnection("ldap://192.168.32.23:389", "cn=Manager,dc=jump,dc=com","startimes@2018", "simple");
			ldap.connect(ldapConnection);
			
//			String testDn = "cn=zhy zabbix,cn=devtest,dc=jump,dc=com";
//			
//			// add uid=test,ou=tester,dc=ibm,dc=com
//			InetOrgPerson addPerson = new InetOrgPerson("z1", "szhy","devtest", "zhy zabbix",testDn);
//			ldap.add(addPerson);
			
			
			// search uid=test
			// specify the LDAP search filter
//			String searchFilter = "cn=san zhang";
//			// Specify the Base for the search
//			String searchBase = "ou=People,dc=jump,dc=com";
//			// Specify the attributes to return
//			String returnedAtts[] = {"uid", "userPassword", "displayName", "cn", "sn", "mail", "gidNumber","description","entryDN","User Name","uidNumber"};
//		    ldap.search(searchFilter,searchBase,returnedAtts);
		    
		    Map<String,String> queryParams = new HashMap<>();
		    String searchBase = "ou=Users,ou=Unified Authentication,ou=Startimes,dc=jump,dc=com";
		    queryParams.put("gidNumber", "504");
		    ldap.searchByAttribute(searchBase, queryParams);
		   
		    
//		    // update cn with new value of "changed name"
//		    Attribute attr = new BasicAttribute("cn", "changed value");
//		    ldap.update(testDn,attr);
//		    
//		    
//		    // search uid=test to see cn value.
//		    ldap.search(searchFilter,searchBase,returnedAtts);
//		    
//		    // delete uid=test,ou=tester,dc=ibm,dc=com
//		    ldap.delete("uid=test,ou=tester,dc=ibm,dc=com");
//		    
//		    // search again.
//		    ldap.search(searchFilter,searchBase,returnedAtts);
		    
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			if(ldap!=null){
				try {
					ldap.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
