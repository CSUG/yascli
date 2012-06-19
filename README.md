Yascli 是从[HouseMD](http://github.com/zhongl/housemd)中独立出来的scala的命令行开发包.
相比较已有的类似开源项目, yascli的优势在于:

- 声明式编程, 编写简单, 阅读易懂
- 支持多种命令行模式扩展:
    1. 单一命令行, 如 `rm -r d*`
    1. 组命令行, 如 `git add`
    1. 交互命令行, 如 `ftp> help`

# 配置依赖

## SBT

`libraryDependencies += "com.github.zhongl" %% "yascli" % "0.1.0"`

## MAVEN

    <dependency>
      <groupId>com.github.zhong</groupId>
      <artifactId>yascli_2.9.2</artifactId>
      <version>0.1.0</version>
    </dependency>

# 入门

    import com.github.zhongl.yascli._
    import com.github.zhongl.yascli.Converters._

    object Example extends Command(name = "example", description = "a example of single command") with Application {
        private val flag0       = flag("-f" :: "--flag" :: Nil, "enable flag")
        private val singleValue = option[String]("--single-value" :: Nil, "set single value", "value")
        private val param       = parameter[String]("param", "set param")

        override def run() {
            if (flag0()) println("enable flag0.")
            println(singleValue())
            println(param())
        }
    }

上面是常见的单一命令行例子, 命令行有一个开关选项`flag0`, 有一个单值选项`singleValue`, 和一个必要的参数`param`. 若运行命令行是:

    > example -f --single-value hello world

则会打印输出:

    enable flag0
    hello
    world

若要打印帮助信息, 则可运行命令行:

    > example -h

则结果会是:

    Usage: example [OPTIONS] param
            a example of single command
    Options:
            -f, --flag
                    enable flag
            --single-value=[STRING]
                    set single value
                    default: value
    Parameters:
            param
                    set param

这是最简单的例子, yascli支持丰富的扩展:

1. [值类型转换](https://github.com/zhongl/yascli/blob/master/src/test/scala/com/github/zhongl/yascli/CommandSpec.scala)
1. [值有效校验](https://github.com/zhongl/yascli/blob/master/src/test/scala/com/github/zhongl/yascli/CommandSpec.scala)
1. [可选参数](https://github.com/zhongl/yascli/blob/master/src/test/scala/com/github/zhongl/yascli/CommandSpec.scala)
1. [多值参数](https://github.com/zhongl/yascli/blob/master/src/test/scala/com/github/zhongl/yascli/CommandSpec.scala)
1. [组命令行](https://github.com/zhongl/yascli/blob/master/src/test/scala/com/github/zhongl/yascli/SuiteSpec.scala)
1. [交互式命令, 参数`tab`自动补全](https://github.com/zhongl/yascli/blob/master/src/test/scala/com/github/zhongl/yascli/ShellSpec.scala)等

更多例子, 请见[`Unit Test Case`](https://github.com/zhongl/yascli/tree/master/src/test/scala/com/github/zhongl/yascli)

# 类似开源项目

请见[StackOverflow](http://stackoverflow.com/questions/2315912/scala-best-way-to-parse-command-line-parameters-cli)

