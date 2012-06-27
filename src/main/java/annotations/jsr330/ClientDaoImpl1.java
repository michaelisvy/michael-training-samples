package annotations.jsr330;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Named("clientDao1")
public class ClientDaoImpl1 implements ClientDao{

}
