# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

#设置生成本地库所需的最小版本的CMASE

cmake_minimum_required(VERSION 3.4.1)


#创建并命名库，将其设置为静态或共享，并提供与其源代码的相对路径。
#你可以定义多个库，CMake为你构建它们。
#你可以用APK自动打包共享库。

# TODO 添加自己写的 C/C++源文件
add_library( #设置库的名称。
             apk_patch

             #将库设置为共享库。
            SHARED

             # 为源文件提供相对路径.
             bspatch.c
             bzip2
             )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

# TODO 依赖 NDK中的库
find_library(log-lib
              log )

#指定库CGube应链接到目标库。可以链接多个库，例如在这个构建脚本中定义的库、预构建的第三方库或系统库。

# TODO 将目标库与 NDK中的库进行连接
target_link_libraries( # 指定目标库.
                       apk_patch

                       #将目标库链接到日志库
                       # included in the NDK.
                       ${log-lib} )