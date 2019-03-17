Merchant's Guide to the Galaxy

目录介绍：
homework：
  exception： 异常包
    HomeWorkException：自定义的异常，继承自RuntimeException
    
  input： 输入包
    Input： 接口
    ScannerInput：从控制台输入  
    TextFileInput：从文件获取输入，需要制定文件绝对路径
  
  output： 输出包
    Output： 输出接口
    ScannerOutput：结果输出到控制台，目前近实现了这一种输出方式
    
  rule：转换规则包
    Rules：主要定义了：Galaxy中的符号到罗马数字之间的映射； 单位资源（common metals and dirt and so on）对应的Credits
    
  service：处理包
    ProcessInput： 处理输入的接口
    WinyProcessInput：自定义的一种处理输入的实现  
    
  symbol：罗马符号包
    Symbol： 枚举，罗马字母到阿拉伯数字之间的映射
    SymbolsParse： 罗马符号组合解析成阿拉伯数字接口
    WinySymbolsParse：自定义的一种罗马符号组合解析成阿拉伯数字的实现
    
  ProgramMain：程序入口
  
代码已上传GitHub。 
  GitHub地址: https://github.com/winygit/thoughtWorks-Hw.git     
  

程序运行说明：
   可使用程序提供的ScannerInput或 TextFileInput输入数据，使用后者需要指明输入文件绝对地址。
   程序的输出将打印在控制台（时间关系，目前仅提供了这一种实现）。
   
   

   
    