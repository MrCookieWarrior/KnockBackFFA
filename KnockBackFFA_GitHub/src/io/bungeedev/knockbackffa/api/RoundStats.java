package io.bungeedev.knockbackffa.api;

import io.bungeedev.knockbackffa.mysql.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author BungeeDev
 **/
public class RoundStats
{
  public static boolean playerExists(String uuid)
  {
    try
    {
      ResultSet rs = MySQL.getResult("SELECT * FROM KnocBackFFA WHERE UUID='" + uuid + "'");
      if (rs.next()) {
        return rs.getString("UUID") != null;
      }
      return false;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }
  
  public static void createPlayer(String uuid, String name)
  {
    if (!playerExists(uuid)) {
      MySQL.update("INSERT INTO KnocBackFFA (UUID, NAME, KILLS, DEATHS) VALUES ('" + uuid + "', '" + name + "', '0', '0');");
    }
  }
  
  public static Integer getKills(String uuid, String name)
  {
    Integer i = Integer.valueOf(0);
    if (playerExists(uuid))
    {
      try
      {
        ResultSet rs = MySQL.getResult("SELECT * FROM KnocBackFFA WHERE UUID='" + uuid + "'");
        if (rs.next()) {
          Integer.valueOf(rs.getInt("KILLS"));
        }
        i = Integer.valueOf(rs.getInt("KILLS"));
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      createPlayer(uuid, name);
      getKills(uuid, name);
    }
    return i;
  }
  
  public static Integer getDeaths(String uuid, String name)
  {
    Integer i = Integer.valueOf(0);
    if (playerExists(uuid))
    {
      try
      {
        ResultSet rs = MySQL.getResult("SELECT * FROM KnocBackFFA WHERE UUID='" + uuid + "'");
        if (rs.next()) {
          Integer.valueOf(rs.getInt("DEATHS"));
        }
        i = Integer.valueOf(rs.getInt("DEATHS"));
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      createPlayer(uuid, name);
      getDeaths(uuid, name);
    }
    return i;
  }
  
  public static void setKills(String uuid, String name, Integer kills)
  {
    if (playerExists(uuid))
    {
      MySQL.update("UPDATE KnocBackFFA SET KILLS='" + kills + "' WHERE UUID='" + uuid + "'");
    }
    else
    {
      createPlayer(uuid, name);
      setKills(uuid, name, kills);
    }
  }
  
  public static void setDeaths(String uuid, String name, Integer deaths)
  {
    if (playerExists(uuid))
    {
      MySQL.update("UPDATE KnocBackFFA SET DEATHS='" + deaths + "' WHERE UUID='" + uuid + "'");
    }
    else
    {
      createPlayer(uuid, name);
      setDeaths(uuid, name, deaths);
    }
  }
  
  public static void addKills(String uuid, String name, Integer kills)
  {
    if (playerExists(uuid))
    {
      setKills(uuid, name, Integer.valueOf(getKills(uuid, name).intValue() + kills.intValue()));
    }
    else
    {
      createPlayer(uuid, name);
      addKills(uuid, name, kills);
    }
  }
  
  public static void addDeaths(String uuid, String name, Integer deaths)
  {
    if (playerExists(uuid))
    {
      setDeaths(uuid, name, Integer.valueOf(getDeaths(uuid, name).intValue() + deaths.intValue()));
    }
    else
    {
      createPlayer(uuid, name);
      addDeaths(uuid, name, deaths);
    }
  }
  
  public static void removeKills(String uuid, String name, Integer kills)
  {
    if (playerExists(uuid))
    {
      setKills(uuid, name, Integer.valueOf(getKills(uuid, name).intValue() - kills.intValue()));
    }
    else
    {
      createPlayer(uuid, name);
      removeKills(uuid, name, kills);
    }
  }
  
  public static void removeDeaths(String uuid, String name, Integer deaths)
  {
    if (playerExists(uuid))
    {
      setKills(uuid, name, Integer.valueOf(getDeaths(uuid, name).intValue() - deaths.intValue()));
    }
    else
    {
      createPlayer(uuid, name);
      removeDeaths(uuid, name, deaths);
    }
  }
}
