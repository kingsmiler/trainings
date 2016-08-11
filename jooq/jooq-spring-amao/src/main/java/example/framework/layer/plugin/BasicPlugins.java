package example.framework.layer.plugin;

import example.framework.layer.security.SercurityGuard;

import java.util.HashSet;
import java.util.Set;

public interface BasicPlugins {
    Set<SercurityGuard> sercurityGuards = new HashSet<>();
}
