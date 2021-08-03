import java.util.Map;
class Solution {
    Map<Integer, String> idToEmail = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = buildEmailToName(accounts);
        int n = emailToName.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToId= buildEmailToId(emailToName);
        for (List<String> act: accounts) {
            int i = emailToId.get(act.get(1));
            for (int index = 2; index < act.size(); index++) {
                int j = emailToId.get(act.get(index));
                uf.union(i, j);

            }
        }
        Map<String, List<String>> fatherToEmails = new HashMap<>();
        for (int i = 0 ; i < uf.father.length; i++) {
            String father = idToEmail.get(uf.father[i]);
            //String father = idToEmail.get(find(i));
            fatherToEmails.putIfAbsent(father, new ArrayList<>());
            String child = idToEmail.get(i); 
            fatherToEmails.get(father).add(child);
        }
        List<List<String>> res = new ArrayList<>();
        for (String father : fatherToEmails.keySet()) {
            List<String> emails = fatherToEmails.get(father);
            System.out.println("father : " + father);
            System.out.println("children : ");
            for (String s: emails) {
                System.out.print(s + " ");
            }
            System.out.println("");
            System.out.println("-------------------");
            Collections.sort(emails);
            String name = emailToName.get(father);
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }
    public class UnionFind {
        int n;
        int[] father;
        UnionFind(int n) {
            this.n = n;
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public int find(int i) {
            if ( father[i] == i) {
                return i;
            }
            father[i] = find(father[i]);
            return father[i];
        }
        public void union(int i, int j) {
            int fatherI = find(i);
            int fatherJ = find(j);
            if (fatherI == fatherJ) {
                return;
            }
            father[fatherI] = fatherJ;
        }
    }

    private Map<String, String> buildEmailToName(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> list : accounts) {
            for (int i = 1; i < list.size(); i++) {
                emailToName.put(list.get(i), list.get(0));
            }
        } 
        return emailToName;
    }


    private Map<String, Integer> buildEmailToId(Map<String, String> emailToName) {
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for (String email : emailToName.keySet()) {
            emailToId.put(email, id);
            idToEmail.put(id, email);
            System.out.println("email: " + email + " id: " + id );
            id++;
            
        }
        return emailToId;
    }
}



// UnionFind use Map
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts);
        for (List<String> account : accounts) {
            String e1 = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                uf.union(e1, account.get(i));
            }
        }

        Map<String, Set<String>> fatherToEmails = new HashMap<>();
        for (String e: emailToName.keySet()) {
            String father = uf.find(e);
            if (!fatherToEmails.containsKey(father)) {
                fatherToEmails.put(father, new HashSet<>());
                fatherToEmails.get(father).add(father);
            }
            fatherToEmails.get(father).add(e);
        }

        List<List<String>> res = new ArrayList<>();
        for (String father : fatherToEmails.keySet()) {
            String name = emailToName.get(father);
            Set<String> emails = fatherToEmails.get(father);
            List<String> curRes = new ArrayList<>();
            
            curRes.addAll(new ArrayList<>(emails));
            Collections.sort(curRes);
            curRes.add(0, name);
            res.add(curRes);
        }
        return res;

    }
    Map<String, String> emailToName = new HashMap<>(); 
    public class UnionFind {
        private Map<String, String> father;//fatherEmail/ all emails
        List<List<String>> accounts;
        UnionFind (List<List<String>> accounts) {
            this.accounts = accounts;
            father = new HashMap<>();
            initialize();
        }
        private void initialize() {
            for (List<String> account : accounts) {
                for (int i = 1; i < account.size(); i++) {
                    father.putIfAbsent(account.get(i), account.get(i));
                    emailToName.putIfAbsent(account.get(i), account.get(0));
                }
            }
        }
        /**
         * find the father email of the email
         */
        public String find(String e) { 
            if (father.get(e).equals(e)) {
                return e;
            }
            father.put(e, find(father.get(e)));
            return father.get(e);
        }

        /**
         * union two email
         */
        public void union(String e1, String e2) {
            String fatherE1 = find(e1);
            String fatherE2 = find(e2);
            if (!fatherE1.equals(fatherE2)) {
                father.put(find(fatherE1), fatherE2);
            }
        }
    }
}