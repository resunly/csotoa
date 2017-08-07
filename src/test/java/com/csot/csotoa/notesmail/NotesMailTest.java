package com.csot.csotoa.notesmail;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.BodyType;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hank.he on 2017/7/19.
 */
public class NotesMailTest {
    private static String username = "scottliu";
    private static String password = "Sl123159";
    private static String demand = "192.168.1.108";//如不清楚，请联系系统管理员 例：corp.chinacache.com

    public static void main(String[] args) {
        List<String> to = new ArrayList<String>();
        to.add("tanyecong@zizhou.com");
        try {
            send("String subject", to, "String bodyText");
        } catch (Exception e) {
            e.printStackTrace();
        }
        query();
    }

    /**
     * 使用Exchange协议发送
     * EWSJavaAPI
     *
     * @throws Exception
     */
    public static void send(String subject, List<String> to, List<String> cc,
                            String bodyText, String realPath) throws Exception {
        // 创建service连接
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2007_SP1);// 选择服务器使用的Exchange版本
        ExchangeCredentials credentials = new WebCredentials(username,
                password, "chinacache");// 用户名、密码
        service.setCredentials(credentials);
        service.setUrl(new URI("https://" + demand + "/ews/exchange.asmx"));// 设置协议地址

        //创建邮件
        EmailMessage msg = new EmailMessage(service);
        // 设置主题
        msg.setSubject(subject);
        // 邮件内容
        MessageBody body = MessageBody.getMessageBodyFromText(bodyText);
        body.setBodyType(BodyType.HTML);
        msg.setBody(body);
        // to 收件人
        for (String s : to) {
            msg.getToRecipients().add(s);
        }
        // cc //抄送
        if (cc != null) {
            for (String s : cc) {
                msg.getCcRecipients().add(s);
            }
        }

        // 附件
        if (realPath != null && !"".equals(realPath)) {
            msg.getAttachments().addFileAttachment(realPath);
        }
        msg.send();
    }

    public static void send(String subject, List<String> to,
                            String bodyText) throws Exception {
        send(subject, to, null, bodyText, null);
    }

    public static void query() {
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2007_SP1);
        //ExchangeCredentials credentials = new WebCredentials("用户名", "密码", "域");
        ExchangeCredentials credentials = new WebCredentials(username,
                password, "chinacache");
        service.setCredentials(credentials);
        try {
            service.setUrl(new URI("https://" + demand + "/EWS/Exchange.asmx"));
            // Bind to the Inbox.
            Folder inbox = Folder.bind(service, WellKnownFolderName.Drafts);
            System.out.println(inbox.getDisplayName());
            ItemView view = new ItemView(10);
            FindItemsResults<Item> findResults = service.findItems(inbox.getId(), view);
            for (Item item : findResults.getItems()) {
                EmailMessage message = EmailMessage.bind(service, item.getId());
                System.out.println(message.getSender());
                System.out.println("Sub -->" + item.getSubject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void conn() {
        boolean result = false;
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2007_SP1);
        //ExchangeCredentials credentials = new WebCredentials("用户名", "密码", "域");
        ExchangeCredentials credentials = new WebCredentials(username,
                password, "chinacache");
        service.setCredentials(credentials);
        try {
            service.setUrl(new URI("https://" + demand + "/EWS/Exchange.asmx"));
            // Bind to the Inbox.
            Folder inbox = Folder.bind(service, WellKnownFolderName.Inbox);
            System.out.println(inbox.getDisplayName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("enclosing_type.enclosing_method()" + result);
    }
}
