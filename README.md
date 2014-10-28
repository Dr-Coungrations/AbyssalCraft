## AbyssalCraft Development .jars

###Installation

If you know how to install compiled jars into your workspace, then just select the mod version you want to integrate into your mod.

If you don't know how to, here are some steps that should solve it:

1. Download the compiled version you want to use for your mod.
2. create a folder called "libs" in the root directory of your workspace (eg if the workspace was named "gradle", the folder would be "gradle/libs")
3. Drop the dev jar into /libs
4. Run gradlew eclipse (or idea if you're using that IDE)
5. The "AbyssalCraft-mcversion-modversion-dev.jar" should now be found under "referenced libraries"

These compiled versions of the mod are to be used if you want to create an Add-on for AbyssalCraft, or if you want to use some of it's functions in your own mod.

As of AbyssalCraft 1.7.8, there will be dev jars and src jars for both 1.7.2 and 1.7.10 builds (use the src jar if you want to be able to see the sourcecode in the dev jar)
