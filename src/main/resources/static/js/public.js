function jumpPage(pageNum, pageSum) {
    pageNum = parseInt(pageNum);
    pageSum = parseInt(pageSum);
    if (pageNum < 1 || pageNum > pageSum) {
        return "当前选择的页码没有数据";
    }
    return true;
}