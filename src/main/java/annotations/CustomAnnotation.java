package annotations;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Resource
public @interface CustomAnnotation {

}
