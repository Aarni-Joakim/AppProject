package com.team1.hyteproject.program;
/**
 * Author Samu Wahlroos
 */

import java.util.HashMap;
import java.util.Map;

    public class Credentials {  private HashMap<String, String> credentialMapper = new HashMap<String, String>();

        /**
         * Adds Credentials from Registration Activity to credentialMapper HashMap.
         * @param username
         * @param password
         * @param age
         * @param eMail
         */
        public void addCredentials(String username, String password, String age, String eMail){
            credentialMapper.put(username, password);
            credentialMapper.put(age, eMail);
        }

        /**
         * If username from LoginActivity matches, returns true.
         * @param username
         * @return
         */
        public boolean checkUsername(String username){
            return credentialMapper.containsKey(username);
        }

        /**
         * If username containsKey matches returns true and login is successful.
         * @param username
         * @param password
         * @return
         */
        public boolean checkCredentials(String username, String password){

            if(credentialMapper.containsKey(username)){
                return password.equals(credentialMapper.get(username));
            }

            return false;
        }

        /**
         * Saves last used login info to preferencesMap if RememberMe check box is active
         * @param preferencesMap
         */
        public void loadCredentials(Map<String, ?> preferencesMap){
            for(Map.Entry<String, ?> entries : preferencesMap.entrySet()){
                if(!entries.getKey().equals("RememberMeCheckbox") || !entries.getKey().equals("LastSavedUsername") ||
                        !entries.getKey().equals("LastSavedPassword")){
                    credentialMapper.put(entries.getKey(), entries.getValue().toString());
                }
            }
        }
    }

