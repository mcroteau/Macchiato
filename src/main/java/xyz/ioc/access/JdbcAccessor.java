package xyz.ioc.access;

import io.github.mcroteau.resources.access.Accessor;

import java.util.Set;

public class JdbcAccessor implements Accessor {

    @Override
    public String getPassword(String s) {
        return null;
    }

    @Override
    public Set<String> getRoles(String s) {
        return null;
    }

    @Override
    public Set<String> getPermissions(String s) {
        return null;
    }
}
