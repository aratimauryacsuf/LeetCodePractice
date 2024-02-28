/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    private String startHostname;
    private HashSet<String> set = new HashSet<>();
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {    startHostname = getHostname(startUrl);
    dfs(startUrl, htmlParser);
    return new ArrayList<>(set);
        
    }
    public String getHostname(String url){
       return url.split("/")[2];
    }
    public void dfs(String url, HtmlParser htmlParser){
        set.add(url);
        for(String newUrl : htmlParser.getUrls(url)){
            if(getHostname(newUrl).equals(startHostname) && !set.contains(newUrl)){
                dfs(newUrl,htmlParser);
            }
        }
    }
}