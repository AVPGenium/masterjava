package ru.javaops.masterjava.xml;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.*;
import ru.javaops.masterjava.xml.util.JaxbParser;
import ru.javaops.masterjava.xml.util.Schemas;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class XmlMain {
    private final JaxbParser JAXB_PARSER = new JaxbParser(ObjectFactory.class);

    public XmlMain() {
        JAXB_PARSER.setSchema(Schemas.ofClasspath("payload.xsd"));
    }

    public List<User> getProjectParticipants(String projectName) throws IOException, JAXBException {
        Payload payload = JAXB_PARSER.unmarshal(
                Resources.getResource("payload.xml").openStream());
        Project project = payload.getProjects().getProject().stream().filter(p -> p.getName().equals(projectName))
                .findAny().orElse(null);
        if (project == null) {
            return Lists.newArrayList();
        }
        Set<String> groupNames = project.getGroups().getGroup().stream().map(Group::getName).collect(Collectors.toSet());
        List<User> result = Lists.newArrayList();
        payload.getUsers().getUser().forEach(user -> {
            Set<String> userGroups = user.getGroups().stream().map(group -> ((Group) group).getName()).collect(Collectors.toSet());
            if (!Sets.intersection(groupNames, userGroups).isEmpty()) {
                result.add(user);
            }
        });
        return result;
    }
}
