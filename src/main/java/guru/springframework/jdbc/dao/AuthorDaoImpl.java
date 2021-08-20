package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jt on 8/20/21.
 */
@Component
public class AuthorDaoImpl implements AuthorDao {

    private final DataSource source;

    public AuthorDaoImpl(DataSource source) {
        this.source = source;
    }

    @Override
    public Author getById(Long id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = source.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM author where id = " + id);

            if (resultSet.next()) {
                Author author = new Author();
                author.setId(id);
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));

                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null){
                    statement.close();
                }

                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}













