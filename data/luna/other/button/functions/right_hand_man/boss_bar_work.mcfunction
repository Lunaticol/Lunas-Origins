execute at @s run bossbar set brh players @a[distance=..128]
execute store result bossbar brh max run attribute @s generic.max_health get
execute store result bossbar brh value run data get entity @s Health
execute unless entity @s run bossbar remove brh