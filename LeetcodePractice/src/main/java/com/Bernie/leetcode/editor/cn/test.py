import zipfile
class Solution:
    tatget_path = "D:\\Program Files\\01-Adobe_Photoshop_2021_22.0.0.35_ACR13.0.2_SP_20201103.zip"

    def __init__(self):
        self.fp = zipfile.ZipFile(self.tatget_path, "r")

    def brutal_extract(self, lengths=[4, ], lower=False, upper=False, digit=False, punctuation=False):
        '''
        # 遍历所有可能的密码，暴力破解
        :param lengths:  密码长度，可以指定所有需要考虑的长度，如[4, 5, 6]等
        :param lower:  是否考虑小写字母
        :param upper:  是否考虑大写字母
        :param digit:  是否考虑数字
        :param punctuation:  是否考虑标点符号
        :return:
        '''
        import string  # 用于生成密码本
        from itertools import combinations  # 用于生成所有可能的密码

        passward_dict = ""
        if lower:
            passward_dict += string.ascii_lowercase
        if upper:
            passward_dict += string.ascii_uppercase
        if digit:
            passward_dict += string.digits
        if punctuation:
            passward_dict += string.punctuation

        print("密码本：\t{}\n密码长度：\t{}\n".format(passward_dict, lengths))

        count = 0
        for length in lengths:
            for passward in combinations(passward_dict, length):
                passward = "".join(passward)
                count += 1
                print(passward, end=" ")
                if self.extract(passward):
                    print()
                    print("一共尝试了{}种可能".format(count))
                    return
        print("对不起，暂未找到，请尝试：\n1. 其他密码长度\n2. 包含更多种类的密码字符")

        # 尝试解压

    def extract(self, passward):
        try:
            print(passward.encode())
            self.fp.extractall(self.tatget_path, passward.encode())
            print()
            print('成功破解该压缩包，密码为： ' + passward)
            self.fp.close()
            return True
        except Exception as ex:
            print(ex)


solution = Solution()
solution.extract("142857")
# solution.brutal_extract([6], False, False, True, False)
