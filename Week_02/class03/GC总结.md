1. 堆内存设置过小，会导致OOM  java -Xmx128m -XX:+PrintGCDetails GCLogAnalysis

2. 堆内存设置太大会导致单次GC时间变长，导致吞吐量降低 

3. GC 的模式

   SerialGC: -XX:+UseSerialGC    使用CPU单个核心，不能发挥多核性能。

   ParallelGC: -XX:+UseParallelGC 多核CPU可充分利用，增加吞吐量，并行清理，总暂停时间更多

   CMSGC: -XX:+UseConcMarkSweepGC 年轻代：标记-复制 老年代：标记-清除

   阶段 1：Initial Mark（初始标记）
   阶段 2：Concurrent Mark（并发标记）
   阶段 3：Concurrent Preclean（并发预清理）
   阶段 4： Final Remark（最终标记）
   阶段 5： Concurrent Sweep（并发清除）
   阶段 6： Concurrent Reset（并发重置）

   G1GC: -XX:+UseG1GC

   Evacuation Pause: young（纯年轻代模式转移暂停）
   Concurrent Marking（并发标记）
   阶段 1: Initial Mark（初始标记）
   阶段 2: Root Region Scan（Root区扫描）
   阶段 3: Concurrent Mark（并发标记）
   阶段 4: Remark（再次标记）
   阶段 5: Cleanup（清理）
   Evacuation Pause (mixed)（转移暂停: 混合模式）
   Full GC (Allocation Failure)

4. JDK9（不包括9）之前是默认为并行GC， JDK9后默认为G1，这两个GC关注点不同，并行GC主要看中吞吐量，而G1主要是关注暂停时间，但是G1对于大内存的情况下效率很高。最后对于Serial GC 作为最早期的GC 其不管电脑是否是多核，都是串行化，在Stop The World时只有GC线程在工作。

