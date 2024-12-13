package ru.itis.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.itis.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    //language=sql
    private static final String SQL_SELECT_ALL_ORDERS ="select * from order_table";
    //language=sql
    private static final String SQL_SELECT_FIND_BY_ID_ORDER ="select * from order_table where (id = ?)";
    final static Logger logger = LogManager.getLogger(OrderRepository.class);

    private DBConnection db = DBConnection.getInstance();

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_ORDERS);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getLong("id"),
                        resultSet.getString("dish_list"),
                        resultSet.getInt("table_number"),
                        resultSet.getString("waiter_name")
                );
                orders.add(order);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            logger.error(e);
        }
        return orders;
    }

    public Order findById(Long id) {
        Order order = null;
        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_FIND_BY_ID_ORDER);

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        resultSet.getLong("id"),
                        resultSet.getString("dish_list"),
                        resultSet.getInt("table_number"),
                        resultSet.getString("waiter_name")
                );
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }
}
