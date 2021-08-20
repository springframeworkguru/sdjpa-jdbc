package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 8/20/21.
 */
@Component
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author getById(Long id) {
        return null;
    }
}
