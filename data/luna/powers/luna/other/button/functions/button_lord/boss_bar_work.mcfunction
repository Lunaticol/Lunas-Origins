execute at @s run bossbar set button players @a[distance=..128]
execute store result bossbar button max run attribute @s generic.max_health get
execute store result bossbar button value run data get entity @s Health
execute unless entity @s run bossbar remove button