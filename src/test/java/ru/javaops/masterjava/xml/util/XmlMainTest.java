package ru.javaops.masterjava.xml.util;

import org.junit.Assert;
import org.junit.Test;
import ru.javaops.masterjava.xml.XmlMain;
import ru.javaops.masterjava.xml.schema.User;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XmlMainTest {
    @Test
    public void testXmlMain() throws IOException, JAXBException {
        XmlMain xmlMain = new XmlMain();
        List<User> userList = xmlMain.getProjectParticipants("topjava");
        Assert.assertArrayEquals(userList.stream().map(User::getFullName).toArray(), new String[]{"Full Name", "Admin"});
    }
}
