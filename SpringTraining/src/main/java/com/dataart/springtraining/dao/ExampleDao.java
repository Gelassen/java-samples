package com.dataart.springtraining.dao;

import com.dataart.springtraining.dto.Application;
import com.dataart.springtraining.dto.TestPic;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional(readOnly = true)
public class ExampleDao {

    private final static Logger LOG = Logger.getLogger(ExampleDao.class);

    private String getAllAppsRequest = "SELECT * FROM applications ORDER BY downloads DESC";

    private String getPopularAppsRequest = "SELECT * FROM applications ORDER BY downloads DESC LIMIT 5";

    private String getAppsByCategoryRequest = "SELECT * FROM applications WHERE type = ? ORDER BY downloads DESC";

    private String getAppByIdRequest = "SELECT * FROM applications WHERE id = ?";

    private String addNewAppRequest = "INSERT INTO applications (name, type, description, downloads, " +
            "package, image, archive) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private String getAllCategoriesRequest = "SELECT DISTINCT type FROM applications";

    private String getUniquePackage = "SELECT DISTINCT package FROM applications WHERE package = ?";

    @Autowired
    @Qualifier(value = "simpleJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public ExampleDao() {

    }

    public ExampleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Application> getAllApplications() {
        List<Application> applications = this.jdbcTemplate.query(getAllAppsRequest, new ApplicationRowMapper());
        return applications;
    }

    public List<Application> getPopularApplications() {
        List<Application> applications = this.jdbcTemplate.query(getPopularAppsRequest, new ApplicationRowMapper());
        return applications;
    }

    public List<Application> getAppsByCategory(String type) {
        List<Application> applications = (List<Application>) this.jdbcTemplate.query(
                getAppsByCategoryRequest,
                new Object[]{type},
                new ApplicationRowMapper());
        return applications;
    }

    public Application getAppById(long appId) {
        Application application = (Application) this.jdbcTemplate.queryForObject(getAppByIdRequest,
                new Object[]{appId},
                new ApplicationRowMapper());
        return application;
    }

    public boolean thisPackageUnique(final String name) {
        List<Application> app =  (ArrayList<Application>) this.jdbcTemplate.query(getUniquePackage,
                new Object[]{name},
                new ApplicationRowMapper());
        return app.size() == 0 ? true : false;
    }


    @Transactional(readOnly = false)
    public void addNewApplication(Application app) {
        this.jdbcTemplate.update(addNewAppRequest, new Object[] {
                app.getName(),
                app.getType(),
                app.getDescription(),
                app.getDownloads(),
                app.getPackageName(),
                app.getImage(),
                app.getArchive()
        });
    }

    public List<String> getAllCategories() {
        List<String> result = this.jdbcTemplate.query(getAllCategoriesRequest, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("type");
            }
        });
        return result;
    }

    public class ApplicationRowMapper implements RowMapper {

        @Override
        public Application mapRow(ResultSet rs, int i) throws SQLException {
            Application application = new Application();
            application.setId(Long.parseLong(rs.getString("id")));
            application.setName(rs.getString("name"));
            application.setType(rs.getString("type"));
            application.setDescription(rs.getString("description"));
            application.setDownloads(rs.getInt("downloads"));
            application.setPackageName(rs.getString("package"));
            application.setImage(rs.getBytes("image"));
            application.setArchive(rs.getBytes("archive"));
            return application;
        }
    }

}
