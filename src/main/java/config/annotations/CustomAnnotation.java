package config.annotations;

import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Resource
public @interface CustomAnnotation {

}
