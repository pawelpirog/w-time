package com.pablo.back.controllers;


import com.pablo.back.model.Worker;
import com.pablo.back.other.NickError;
import com.pablo.back.repository.WorkerRepository;
import com.pablo.back.service.WorkerService;
//import jdk.nashorn.internal.ir.RuntimeNode;
import com.sun.mail.pop3.POP3Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.mail.AbstractMailReceiver;
import org.springframework.integration.mail.MailReceiver;
import org.springframework.integration.mail.Pop3MailReceiver;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/workers")
//@CrossOrigin                        //sprawdzic czy zadziala b ez
@CrossOrigin(origins = "http://localhost:4200")
public class WorkerC {


    public static final Logger logger = LoggerFactory.getLogger(WorkerC.class);

    @Autowired
    private WorkerService workerService;
    private WorkerRepository workerRepository;


    //  @CrossOrigin
    @PostMapping("addworker")
    public ResponseEntity<?> createUser(@RequestBody Worker newWorker) {
        if (workerService.find(newWorker.getNick()) != null) {
            logger.error("username Already exist " + newWorker.getNick());
            return

                    new ResponseEntity(
                            new NickError("user with username " + newWorker.getNick() + "already exist "),
                            HttpStatus.CONFLICT);
        }


        return new ResponseEntity<Worker>(workerService.save(newWorker), HttpStatus.CREATED);
    }


    @Autowired
    public WorkerC(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;


        workerRepository.save(new Worker(1, "Paweł", "Piróg", "pp", "mk", new ArrayList<>()));
        //worker.add(new Worker(1,"Paweł","Piróg","pp","mk"));
        //workers.add(new Worker(2,"Tomasz","Krajowy","tt","kk"));
    }

    @RequestMapping("/find/{nick}")
    @ResponseBody
    public Worker getWorker(@PathVariable("nick") String nick) {


        //System.out.println(workerRepository.findWorkerByNick(nick).getWorkers().get(0));
        return workerRepository.findWorkerByNick(nick);
    }


    @RequestMapping("/all")
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @RequestMapping("/all/{nick}")
    public List<Worker> getMyWorkers(@PathVariable String nick) {
        Worker w = workerRepository.findWorkerByNick(nick);

        System.out.println(w.getWorkers().get(0) + " oraz tak ma by");


        Worker x = workerRepository.findWorkerByNick(nick);
        ArrayList<Worker> workers = new ArrayList<>();

        for (int i = 0; i < x.getWorkers().size(); i++) {

            workers.add(workerRepository.findWorkerByNick(x.getWorkers().get(i)));

        }
        return workers;
    }


//@RequestMapping("/thisworker")
//    public Worker getWorker();


    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public void deleteWorker(@PathVariable("id") long id) {

        // Worker w=workerRepository.findWorkerByWorkerID(id);
        //  return workerRepository.delete(w);
        //return workerRepository.findAll();
        workerService.deleteWorker(id);


    }

    @PostMapping("addsubworker")
    public ArrayList<String> addMYWorker(@RequestBody String[] myWorkers) {
        if (workerRepository.findWorkerByNick(myWorkers[0]) != null && workerRepository.findWorkerByNick(myWorkers[1]) != null) {


            workerRepository.findWorkerByNick(myWorkers[0]).getWorkers().add(myWorkers[1]);
            workerRepository.findWorkerByNick(myWorkers[1]).setPrzelozony(myWorkers[0]);

            workerRepository.save(workerRepository.findWorkerByNick(myWorkers[0]));
            workerRepository.save(workerRepository.findWorkerByNick(myWorkers[1]));


        } else {
            System.out.println("nick sie nie zgadza albo cos");
            return null;
        }


        System.out.println(workerRepository.findWorkerByNick(myWorkers[0]).getWorkers().get(0) + " oraz tak ma by");


        System.out.println("moje pieski to: " + myWorkers[0] + " oraz " + myWorkers[1]);


        return workerRepository.findWorkerByNick(myWorkers[0]).getWorkers();
    }


    @RequestMapping(value = "/mail/{id}", method = RequestMethod.GET)
    public static String[] getMails(@PathVariable("id") String id) throws Exception {
        System.out.println("jestem tutaj");


        //todo tutaj spersonalizuje maila ale to dopiero pozniej


//        Pop3MailReceiver receiver
//
//        MailReceiver ml


        MailReceiver receiver = new Pop3MailReceiver("pop.gmail.com",  "testspring997", "Qazxcde321");

        String[] wiadmoscif = (String[]) receiver.receive();

     //   System.out.println(receiver.);

        for(int i=0;i<wiadmoscif.length;i++){
            System.out.println("moja kolejna wiadomsoc to "+ wiadmoscif[i]);

        }


//    System.out.println("moje wiad to "+);

        //      String[] wiadomosci = (String[]) receiver.receive();

//        if(wiadomosci==null)
//            System.out.println("brak  wiadomosci.");


        // mail server connection parameters
//        String host = "smtp.mailtrap.io";
//        String user = "d59b691fcb2786";
//        String password = "8bc668e456053e";


        String host = "pop.gmail.com";
        String user = "testspring997";
        String password = "Qazxcde321";


        // connect to my pop3 inbox
        Properties properties = System.getProperties();


        Session session = Session.getDefaultInstance(properties);


        Store store = session.getStore("pop3");
        store.connect(host, user, password);
        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_ONLY);

        // get the list of inbox messages
        Message[] messages = inbox.getMessages();
        ArrayList<String> mymessages = new ArrayList<>();
        String[] msgs = new String[2];

        if (messages.length == 0) System.out.println("No messages found.");

        for (int i = 0; i < messages.length; i++) {
            mymessages.add(" cze");

            // stop after listing ten messages
            if (i > 10) {
                System.exit(0);
                inbox.close(true);
                store.close();
            }


            System.out.println("Message " + (i + 1));
            mymessages.get(i).concat("Message " + (i + 1) + " From : " + messages[i].getFrom()[0] + " Subject : " + messages[i].getSubject() + " Sent Date : " + messages[i].getSentDate());
            // mymessages.get(i).

            System.out.println("From : " + messages[i].getFrom()[0]);
            System.out.println("Subject : " + messages[i].getSubject());
            System.out.println("Sent Date : " + messages[i].getSentDate());
            System.out.println();
        }

        inbox.close(true);
        store.close();

        //    msgs.add("pierwsza harkodowana wiadomosc");
        //    msgs.add("druga harkodowana wiadomosc");
        msgs[0] = "pierwsza harkodowana wiadomosc";
        msgs[1] = "druga harkodowana wiadomosc";

        System.out.println("jestem tutaj");


        return msgs;

    }
















    public static void receiveEmail(String pop3Host, String storeType,
                                    String user, String password) {



        String host="";

    //    String host = "mail.javatpoint.com";//change accordingly
        String mailStoreType = "pop3";
        String username= "sonoojaiswal@javatpoint.com";
        String passwosrd= "xxxxx";//change accordingly




            try {
                //1) get the session object
                Properties properties = new Properties();
                properties.put("mail.pop3.host", pop3Host);
                Session emailSession = Session.getDefaultInstance(properties);

                //2) create the POP3 store object and connect with the pop server
                POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);

                emailStore.connect(user, password);


            //3) create the folder object and open it
                Folder emailFolder = emailStore.getFolder("INBOX");
                emailFolder.open(Folder.READ_ONLY);

                //4) retrieve the messages from the folder in an array and print it
                Message[] messages = emailFolder.getMessages();
                for (int i = 0; i < messages.length; i++) {
                    Message message = messages[i];
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Text: " + message.getContent().toString());
                }

                //5) close the store and folder objects
                emailFolder.close(false);
                emailStore.close();


            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        //totaj moje dane


            receiveEmail(host, mailStoreType, username, password);

        }
    }







    
