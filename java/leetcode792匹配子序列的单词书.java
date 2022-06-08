

import java.util.*;

public class leetcode792匹配子序列的单词书 {
    public int numMatchingSubseq(String S, String[] words) {
        //变量记录子序列单词个数
        int ans = 0;
        //创建一个26个字母的数组做桶
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();
        //根据数组中每个单词的首字母，将数组中的每个元素分配到与其对应的字母桶中
        for (String word: words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        // 循环一个一个的判断输入的S字符串中的单词
        for (char c: S.toCharArray()) {
            //把对应的桶取出来，并重置该位置的桶
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();
            //循环桶中的元素
            for (Node node: old_bucket) {
                //index++的原因是因为index初始值为0，而长度最小为1，不加则无法匹配
                node.index++;
                //假如桶中元素和其长度相等，即'a' = 'a' 情况的时候，则子序列个数+1
                if (node.index == node.word.length()) {
                    ans++;
                    //否则将桶中元素的下一个字符保存到对应桶中
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            //将暂存的桶重置
            old_bucket.clear();
        }
        return ans;
    }
}
