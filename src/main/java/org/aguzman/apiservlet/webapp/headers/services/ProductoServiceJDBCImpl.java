package org.aguzman.apiservlet.webapp.headers.services;

import org.aguzman.apiservlet.webapp.headers.models.Producto;
import org.aguzman.apiservlet.webapp.headers.repositories.ProductoRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJDBCImpl implements ProductoService{

    private ProductoRepositoryImpl repositoryJDBC;

    public ProductoServiceJDBCImpl(Connection connection) {
        this.repositoryJDBC = new ProductoRepositoryImpl(connection);
    }

    @Override
    public List<Producto> listar() {
        try {
            return repositoryJDBC.listar();
        } catch (SQLException throwables) {
            throw new ServiceJDBCException(throwables.getMessage(),throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJDBC.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJDBCException(throwables.getMessage(),throwables.getCause());
        }

    }
}
