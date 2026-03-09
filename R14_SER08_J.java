try {
  ZoneInfo zi = (ZoneInfo) AccessController.doPrivileged(
    new PrivilegedExceptionAction() {
      public Object run() throws Exception {
        return input.readObject();
      }
  });
  if (zi != null) {
    zone = zi;
  }
} catch (Exception e) 
{
  // Handle error
}
