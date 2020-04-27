# Final Project v1: PlatformJump
# 
# Input these commands into Windows PowerShell while in the PlatformJump folder
# To build: javac *.java
# To execute: java PlatformJump
# 
# Instructions on how to play so far:
# Use A to move left
# Use D to move right
# Use W to jump
# Use S while jumping to fastfall to the ground
# The goal of the player at this time is to reach the two blocks at the top right of the stage.
# 
# @author Fidel Herrera
# Email: fidelherrera@lewisu.edu
# 
# Functions implemented so far in version 1:
# Player can move left, right, jump, and fall to the ground quickly while jumping.
# Player moves at a speed that I found to be comfortable for players new to platformers
# and for veterans of the genre.
# There is collision detection so the player does not run through walls or fall through the
# platforms.
# The platforms in the level have been carefully placed but the level so far is quite simple.
# 
# Functions intended to be implemented in version 2:
# I would like to implement a menu into the game
# I would also like for the level to be a little bit longer so I would like for the screen to be
# able to scroll. 
# I would like there to be a clear beginning and end to the level.
# 
# Functions I would like to see but that will not be implemented:
# More movement objects for the player like an airdash.
# Enemies for the player to avoid.
# More levels for the player to experience.
# 
# MAJOR Credit goes to the Youtube channels Matthew Bellavia and Patrick Feltes as most of the
# code I wrote was made by following their tutorials on creating 2D platformers in Java. Credit to
# Matthew Bellavia for the functions involving collision between the player and the walls. He also
# showed how to make the player move and taught how to create a timer for the game. Credit to
# Rodreigo Monteiro for his guide on implementing 2D platformers. It can be found here:
# http://higherorderfun.com/blog/2012/05/20/the-guide-to-implementing-2d-platformers/