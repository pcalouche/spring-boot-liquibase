DO
$$
BEGIN
  IF NOT EXISTS(
      SELECT
      FROM pg_user
      WHERE usename = 'cool_user')
  THEN
    CREATE USER cool_user
    WITH PASSWORD 'coolPassword';
  END IF;
  CREATE SCHEMA IF NOT EXISTS cool_schema;
  ALTER SCHEMA cool_schema
  OWNER TO cool_user;
  GRANT ALL PRIVILEGES ON SCHEMA cool_schema TO cool_user;
  GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA cool_schema TO cool_user;
  GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA cool_schema TO cool_user;
END
$$;