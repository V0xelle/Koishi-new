/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class DanmakuParanoia extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(DanmakuParanoia.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("DanmakuParanoia.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int BLOCK = 13;
/*    */   
/*    */   private static final int UPGRADE_PLUS_BLOCK = 5;
/*    */   private static final int MULTIPLIER = 1;
/*    */   
/*    */   public DanmakuParanoia() {
/* 34 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.baseBlock = 13;
/* 36 */     this.magicNumber = this.baseMagicNumber = 1;
/* 37 */     KoishiMod.setBackground((CustomCard)this, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 42 */     KoishiMod.runAnimation("spellA");
/* 43 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 49 */     return 20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 55 */     int realBaseBlock = this.baseBlock;
/* 56 */     this.baseBlock += countTerror() * this.magicNumber;
/* 57 */     super.calculateCardDamage(mo);
/* 58 */     this.baseBlock = realBaseBlock;
/* 59 */     this.isBlockModified = (this.block != this.baseBlock);
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 64 */     int realBaseBlock = this.baseBlock;
/* 65 */     this.baseBlock += countTerror() * this.magicNumber;
/* 66 */     super.applyPowers();
/* 67 */     this.baseBlock = realBaseBlock;
/* 68 */     this.isBlockModified = (this.block != this.baseBlock);
/*    */   }
/*    */   
/*    */   public static int countTerror() {
/* 72 */     int count = 0;
/* 73 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 74 */     while (iterator.hasNext()) {
/* 75 */       AbstractMonster m = iterator.next();
/* 76 */       if (m.hasPower(TerrorPower.POWER_ID)) {
/* 77 */         count += (m.getPower(TerrorPower.POWER_ID)).amount;
/*    */       }
/*    */     } 
/*    */     
/* 81 */     return count;
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 86 */     if (!this.upgraded) {
/* 87 */       upgradeName();
/* 88 */       upgradeBlock(5);
/* 89 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/DanmakuParanoia.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */