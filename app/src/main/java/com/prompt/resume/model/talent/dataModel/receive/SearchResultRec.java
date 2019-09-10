package com.prompt.resume.model.talent.dataModel.receive;

import java.util.List;

/**
 * author ：hm
 * date : 2019/9/9 14:38
 * package：com.prompt.resume.model.talent.dataModel.receive
 * description :
 */
public class SearchResultRec {

    /**
     * total : 1
     * list : [{"resumeNo":"1027263220","name":"包先生|4年工作经验|本科","job":"学生实践","workYear":"4","area":"宁波-鄞州区","degree":"本科","age":26,"sex":"男","graduatedSchool":"浙江大学宁波理工学院","mobile":"获取详情后可见","buyFlag":false,"collectFlag":false,"intentFlag":false,"workExpList":[{"companyName":"兼职测绘配电箱的钣金设计","position":"学生实践","trade":"","startTime":"2015.09","endTime":"2015.10"},{"companyName":"瓦楞纸板打包机改造设计","position":"学生实践","trade":"","startTime":"2015.07","endTime":"至今"}],"educationExpList":[{"schoolName":"浙江大学宁波理工学院","major":"机械设计制造及其自动化","startTime":"2012.09","endTime":"2016.06"},{"schoolName":"同济中学","major":"","startTime":"2009.09","endTime":"2012.06"}]}]
     * pageNum : 1
     * pageSize : 20
     * size : 0
     * startRow : 0
     * endRow : 0
     * pages : 1
     * prePage : 0
     * nextPage : 0
     * isFirstPage : false
     * isLastPage : false
     * hasPreviousPage : false
     * hasNextPage : false
     * navigatePages : 0
     * navigatepageNums : null
     * navigateFirstPage : 0
     * navigateLastPage : 0
     */

    private int total;
    private int pageNum;
    private int pageSize;
    private int size;
    private int startRow;
    private int endRow;
    private int pages;
    private int prePage;
    private int nextPage;
    private boolean isFirstPage;
    private boolean isLastPage;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int navigatePages;
    private Object navigatepageNums;
    private int navigateFirstPage;
    private int navigateLastPage;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public Object getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(Object navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public int getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * resumeNo : 1027263220
         * name : 包先生|4年工作经验|本科
         * job : 学生实践
         * workYear : 4
         * area : 宁波-鄞州区
         * degree : 本科
         * age : 26
         * sex : 男
         * graduatedSchool : 浙江大学宁波理工学院
         * mobile : 获取详情后可见
         * buyFlag : false
         * collectFlag : false
         * intentFlag : false
         * workExpList : [{"companyName":"兼职测绘配电箱的钣金设计","position":"学生实践","trade":"","startTime":"2015.09","endTime":"2015.10"},{"companyName":"瓦楞纸板打包机改造设计","position":"学生实践","trade":"","startTime":"2015.07","endTime":"至今"}]
         * educationExpList : [{"schoolName":"浙江大学宁波理工学院","major":"机械设计制造及其自动化","startTime":"2012.09","endTime":"2016.06"},{"schoolName":"同济中学","major":"","startTime":"2009.09","endTime":"2012.06"}]
         */

        private String resumeNo;
        private String name;
        private String job;
        private String workYear;
        private String area;
        private String degree;
        private int age;
        private String sex;
        private String graduatedSchool;
        private String mobile;
        private boolean buyFlag;
        private boolean collectFlag;
        private boolean intentFlag;
        private List<WorkExpListBean> workExpList;
        private List<EducationExpListBean> educationExpList;

        public String getResumeNo() {
            return resumeNo;
        }

        public void setResumeNo(String resumeNo) {
            this.resumeNo = resumeNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getWorkYear() {
            return workYear;
        }

        public void setWorkYear(String workYear) {
            this.workYear = workYear;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getGraduatedSchool() {
            return graduatedSchool;
        }

        public void setGraduatedSchool(String graduatedSchool) {
            this.graduatedSchool = graduatedSchool;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public boolean isBuyFlag() {
            return buyFlag;
        }

        public void setBuyFlag(boolean buyFlag) {
            this.buyFlag = buyFlag;
        }

        public boolean isCollectFlag() {
            return collectFlag;
        }

        public void setCollectFlag(boolean collectFlag) {
            this.collectFlag = collectFlag;
        }

        public boolean isIntentFlag() {
            return intentFlag;
        }

        public void setIntentFlag(boolean intentFlag) {
            this.intentFlag = intentFlag;
        }

        public List<WorkExpListBean> getWorkExpList() {
            return workExpList;
        }

        public void setWorkExpList(List<WorkExpListBean> workExpList) {
            this.workExpList = workExpList;
        }

        public List<EducationExpListBean> getEducationExpList() {
            return educationExpList;
        }

        public void setEducationExpList(List<EducationExpListBean> educationExpList) {
            this.educationExpList = educationExpList;
        }

        public static class WorkExpListBean {
            /**
             * companyName : 兼职测绘配电箱的钣金设计
             * position : 学生实践
             * trade :
             * startTime : 2015.09
             * endTime : 2015.10
             */

            private String companyName;
            private String position;
            private String trade;
            private String startTime;
            private String endTime;

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getTrade() {
                return trade;
            }

            public void setTrade(String trade) {
                this.trade = trade;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }
        }

        public static class EducationExpListBean {
            /**
             * schoolName : 浙江大学宁波理工学院
             * major : 机械设计制造及其自动化
             * startTime : 2012.09
             * endTime : 2016.06
             */

            private String schoolName;
            private String major;
            private String startTime;
            private String endTime;

            public String getSchoolName() {
                return schoolName;
            }

            public void setSchoolName(String schoolName) {
                this.schoolName = schoolName;
            }

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }
        }
    }
}
