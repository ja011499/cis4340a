private static class CalendarAccessControlContext {
  private static final AccessControlContext INSTANCE;
    static {
      RuntimePermission perm =
          new RuntimePermission("accessClassInPackage.sun.util.calendar");
      PermissionCollection perms = perm.newPermissionCollection();
      perms.add(perm);
      INSTANCE = new AccessControlContext(new ProtectionDomain[] {
          new ProtectionDomain(null, perms)
      });
    }
  }

// ...
try {
  zi = AccessController.doPrivileged(
      new PrivilegedExceptionAction<ZoneInfo>() {
        public ZoneInfo run() throws Exception {
          return (ZoneInfo) input.readObject();
        }
      }, CalendarAccessControlContext.INSTANCE);
} catch (PrivilegedActionException pae) { /* ... */ }
if (zi != null) {
  zone = zi;
}
