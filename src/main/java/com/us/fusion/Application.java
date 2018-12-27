package com.us.fusion;

import com.us.person.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by yangyibo on 17/1/3.
 */
public class Application {
    private static KieSession getSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession("fusionAgeKS");
    }

    public static void run() {

        KieSession ks = getSession();
        Person p1 = new Person("白展堂", 2);
        Person p2 = new Person("李大嘴", 16);

        ks.insert(p1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        ks.insert(p2);
//      }


        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则------------------------------");

        ks.dispose();
    }


    public static void main(String[] args) {
        run();
    }

}
